package com.supermarket.billing.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.billing.DTO.BillingRequestDTO;
import com.supermarket.billing.DTO.BillingResponseDTO;
import com.supermarket.billing.ExceptionCentral.BillNotFoundException;
import com.supermarket.billing.Modal.Billing;
import com.supermarket.billing.Service.BillingService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/bills")


public class BillingAPI {
	@Autowired
	BillingService billingService;
	
	@GetMapping(produces = "application/json")
	public List<BillingResponseDTO> getAllBills(@RequestParam(required = false) String name){
		List<BillingResponseDTO> billingResponseDTOList = billingService.getAllBills(name);
		if (billingResponseDTOList.size() > 0) {
			return billingResponseDTOList;
		}
		throw new BillNotFoundException();
	}
	
	
	@GetMapping("/{id}")
	public BillingResponseDTO getBillById(@PathVariable int id) {
		return billingService.getBillById(id);
	}
	
	@PostMapping
	public BillingResponseDTO addNewBill(@RequestBody BillingRequestDTO billingRequestDTO) {
		return billingService.addNewBill(billingRequestDTO);
	}
	
	@PutMapping("/{id}")
	public BillingResponseDTO updateOldBillById(@PathVariable int id,@RequestBody BillingRequestDTO billingRequestDTO) {
		return billingService.updateOldBillById(id,billingRequestDTO);
	}
	
	@DeleteMapping("/{id}")
	public BillingResponseDTO removeOldBillById(@PathVariable int id) {
		return billingService.removeOldBillById(id);
	}
	
	
	
	  @GetMapping("/Paid") 
	  public List<BillingResponseDTO> findByBillPaid() {
	  return billingService.findByPaid(true); 
	  }
	
}
