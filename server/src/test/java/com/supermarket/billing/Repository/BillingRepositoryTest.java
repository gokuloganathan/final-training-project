package com.supermarket.billing.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.supermarket.billing.Modal.Billing;

@DataJpaTest
class BillingRepositoryTest {
	@Autowired
	private BillingRepository billingRepository;
	
	@Test
	void findAll_should_return_billings_list() {
		//when 
		List<Billing> bills = this.billingRepository.findAll();
		
		//then
		assertEquals(6, bills.size());
	}
	
	
	@Test
	void findById_should_return_bill() {
		//when
		Optional<Billing> billingsOptional = billingRepository.findById(1);
		
		//then
		assertTrue(billingsOptional.isPresent());
	}
	
	
	@Test
	void save_should_insert_new_employee() {
		//given
		Billing newBilling = new Billing();
		newBilling.setBillerName("FIRST_NAME");
		newBilling.setBillAmount(100);
		
		//when
		Billing persistingBilling = this.billingRepository.save(newBilling);
		
		assertNotNull(persistingBilling);
		
		/*assertEquals(7, persistingBilling.getBillId());;
		assertEquals("FIRST_NAME",persistingBilling.getBillerName());
		assertEquals(100, persistingBilling.getBillAmount());
		*/
		
		assertSame(newBilling, persistingBilling);
	}
	
	
	@Test 
	void update_should_update_existing_bill() {
		//given
		Billing existingBilling = new Billing();
		existingBilling.setBillId(1);
		existingBilling.setBillerName("FIRST_NAME");
		existingBilling.setBillAmount(10000);
		
		//when
		Billing updatedBilling = this.billingRepository.save(existingBilling);
		
		//then
		assertNotNull(updatedBilling);
		
	}

}
