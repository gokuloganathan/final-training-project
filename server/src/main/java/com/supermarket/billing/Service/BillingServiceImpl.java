package com.supermarket.billing.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.billing.DTO.BillingRequestDTO;
import com.supermarket.billing.DTO.BillingResponseDTO;
import com.supermarket.billing.ExceptionCentral.BillNotFoundException;
import com.supermarket.billing.Modal.Billing;
import com.supermarket.billing.Repository.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService{
	@Autowired
	private BillingRepository billingRepository;

	@Override
	public List<BillingResponseDTO> getAllBills(String name) {
		List<Billing> billingList=new ArrayList<Billing>();
		if(name == null)
		    billingRepository.findAll().forEach(billingList::add);
		else
			billingRepository.findByBillerName(name).forEach(billingList::add);
		
		List<BillingResponseDTO> billingResponseDTOList = billingList.stream().map((bill)-> new BillingResponseDTO(bill)).collect(Collectors.toList());
		return billingResponseDTOList;
	}

	@Override
	public BillingResponseDTO getBillById(int id) {
		Optional<Billing> billingOptional = billingRepository.findById(id);
		if(billingOptional.isPresent()) {
			Billing billing = billingOptional.get();

			return new BillingResponseDTO(billing);
		}
		throw new BillNotFoundException();
	}

	@Override
	public BillingResponseDTO addNewBill(BillingRequestDTO billingRequestDTO) {
		Billing newBilling = new Billing(billingRequestDTO);
		Billing savedBill = billingRepository.save(newBilling);
		
		
		return new BillingResponseDTO(savedBill);
	}

	@Override
	public BillingResponseDTO updateOldBillById(int id, BillingRequestDTO billingRequestDTO) {
		Optional<Billing> fetchedBillOptional = billingRepository.findById(id);
		if(fetchedBillOptional.isPresent()) {
			Billing billing =new Billing(fetchedBillOptional.get());
			billingRepository.flush();
			
			return new BillingResponseDTO(billing);
		}
		throw new BillNotFoundException();
	}

	@Override
	public BillingResponseDTO removeOldBillById(int id) {
		Optional<Billing> billingOptional = billingRepository.findById(id);
		if(billingOptional.isPresent()) {
			Billing deletedBilling = billingOptional.get();
			billingRepository.deleteById(id);
			
			return new BillingResponseDTO(deletedBilling);
		}
		throw new BillNotFoundException();
	}

	@Override
	public List<BillingResponseDTO> findByPaid(boolean Paid) {
		List<Billing> paidBillingList = billingRepository.findByBillPaid(Paid);
		
		if(paidBillingList.size() > 0) {
			List<BillingResponseDTO> paidBillingResponseDTOsList = paidBillingList.stream().map((bill)-> new BillingResponseDTO(bill)).collect(Collectors.toList());
			return paidBillingResponseDTOsList;
		}
		
		throw new BillNotFoundException();
	}
	
}
