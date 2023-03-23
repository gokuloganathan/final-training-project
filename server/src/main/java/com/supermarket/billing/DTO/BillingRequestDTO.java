package com.supermarket.billing.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillingRequestDTO {
	
	private String billerName;
	
	private int billAmount;
	
	private boolean billPaid; 
}
