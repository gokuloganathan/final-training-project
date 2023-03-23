package com.supermarket.billing.DTO;

import com.supermarket.billing.Modal.Billing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BillingResponseDTO {
	private int billId;
	
	private String billerName;
	
	private int billAmount;
	
	
	private boolean billPaid;
	 	
	public BillingResponseDTO(Billing billing) {
		this.setBillId(billing.getBillId());
		this.setBillerName(billing.getBillerName());
		this.setBillAmount(billing.getBillAmount());
		this.setBillPaid(billing.isBillPaid()); 
	}
}
