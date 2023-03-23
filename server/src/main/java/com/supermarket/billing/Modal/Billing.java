package com.supermarket.billing.Modal;


import com.supermarket.billing.DTO.BillingRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Bills")
public class Billing {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "Bill_ID")
	private int billId;
	
	@Column(name = "Biller_Name")
	private String billerName;
	
	@Column(name = "Total_Bill_Amount")
	private int billAmount;
	
	 @Column(name="Paid")
	 private boolean billPaid;
	
	public Billing(BillingRequestDTO billingRequestDTO) {
		this.setBillerName(billingRequestDTO.getBillerName());
		this.setBillAmount(billingRequestDTO.getBillAmount());
		this.setBillPaid(billingRequestDTO.isBillPaid()); 
	}
	
	public Billing(Billing billing) {
		this.setBillerName(billing.getBillerName());
		this.setBillAmount(billing.getBillAmount());
		this.setBillPaid(billing.isBillPaid()); 
	}

}
