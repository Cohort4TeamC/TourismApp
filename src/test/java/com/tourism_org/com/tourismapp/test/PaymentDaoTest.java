package com.tourism_org.com.tourismapp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.tourism_org.com.tourismapp.dao.PaymentDao;
import com.tourism_org.com.tourismapp.model.Payment;

public class PaymentDaoTest {


	int unexpected = 0;
	
	@Test
	public void testUserDbCall() {
		PaymentDao paymentDao = new PaymentDao();
		List<Payment> payments = paymentDao.getAll();
		int actual = payments.size();
		
		assertNotEquals(unexpected, actual);
	}
	

	int Payment_id = 14001;
	
	@Test
	public void testAPayment() {
		PaymentDao paymentDao = new PaymentDao();
		Payment payments = paymentDao.getAPayment(Payment_id);
		
		assertNotNull(payments);
	}
	
	private int expected = 4;
	@Test
	public void GetPayments() {
		PaymentDao paymentDao = new PaymentDao();
		List<Payment> payments = paymentDao.getPaymentFromDb();
		int actual = payments.size();
		
		assertEquals(expected, actual);
	}
	
	// PUT Annotation Test when you need to add a Package
	
	public void AddPayment() {
		
		int expected = 1;
				
		Payment payment = new Payment();

		payment.setPayment_id(14005);
		payment.setCardType("Visa");
		payment.setCardNo("584514474548");
	    payment.setCVV(482);
		payment.setExpDate("05/25");
	//  payment.setPaymentDate("2021-11-15");
	//	payment.setAmountPaid(19000.00);
		
		
		PaymentDao paymentDao = new PaymentDao();
		int actual = paymentDao.addPayment(payment);
				
		assertEquals(expected, actual);
	
	}
}
