package com.tourism_org.com.tourismapp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import com.tourism_org.com.tourismapp.dao.inquiryDao;
import com.tourism_org.com.tourismapp.model.inquiry;


public class InquiryTest {

	@Test
	public void testInquiry() {
		
		inquiry Inquiry = new inquiry();
		
		Inquiry.setEmail("rayyaan@gmail.com");
		Inquiry.setDesc("Sample Inquiry");

		inquiryDao InquiryDao = new inquiryDao();
		int actual = InquiryDao .addInquiry(Inquiry);

		assertNotNull(actual);
			
	}
	
	private int expected =8;
	
	@Test
	public void testGetInquiries() {
		inquiryDao InquiryDao = new inquiryDao ();
		List <inquiry> inquiries =  InquiryDao.getInquiryFromDb();
	    int actual = inquiries.size();
	    assertEquals(expected, actual);
	
	}
	
}
