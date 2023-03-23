package com.supermarket.billing.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.billing.Modal.Billing;

public interface BillingRepository extends JpaRepository<Billing, Integer>{
	/* List<Billing> findByPaid(boolean Paid); */ 
	 List<Billing> findByBillPaid(boolean paid);      /*creating custom func syntax findBy[Var name in declared in  modal]()*/
	 List<Billing> findByBillerName(String name); 
}


