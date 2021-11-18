package com.tourism_org.com.tourismapp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.tourism_org.com.tourismapp.dao.FeedbackDao;
import com.tourism_org.com.tourismapp.model.Feedback;

public class FeedbackDaoTest {


		int unexpected = 0;
		
		@Test
		public void testUserDbCall() {
			FeedbackDao feedbackDao = new FeedbackDao();
			List<Feedback> feedbacks = feedbackDao.getAll();
			int actual = feedbacks.size();
			
			assertNotEquals(unexpected, actual);
		}
		
		
		int feedback_id = 4;
		
		@Test
		public void testAFeedback() {
			FeedbackDao feedbackDao = new FeedbackDao();
			Feedback feedbacks = feedbackDao.getAFeedback(feedback_id);
			
			assertNotNull(feedbacks);
		}
		
		private int expected = 2;
		@Test
		public void GetFeedbacks() {
			FeedbackDao feedbackDao = new FeedbackDao();
			List<Feedback> feedbacks = feedbackDao.getFeedbackFromDb();
			int actual = feedbacks.size();
			
			assertEquals(expected, actual);
		}
		
}