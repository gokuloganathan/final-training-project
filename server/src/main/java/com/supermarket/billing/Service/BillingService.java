package com.supermarket.billing.Service;

import java.util.List;
import java.util.Optional;

import com.supermarket.billing.DTO.BillingRequestDTO;
import com.supermarket.billing.DTO.BillingResponseDTO;
import com.supermarket.billing.Modal.Billing;

public interface BillingService {

	List<BillingResponseDTO> getAllBills(String name);

	BillingResponseDTO getBillById(int id);

	BillingResponseDTO addNewBill(BillingRequestDTO billingRequestDTO);

	BillingResponseDTO updateOldBillById(int id, BillingRequestDTO billingRequestDTO);

	BillingResponseDTO removeOldBillById(int id);

	List<BillingResponseDTO> findByPaid(boolean Paid);
	
}
