package com.tourism_org.com.tourismapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tourism_org.com.tourismapp.config.DbConnection;
import com.tourism_org.com.tourismapp.model.inquiry;

public class inquiryDao {

	private Logger logger = LogManager.getLogger(inquiryDao.class);
	
	
	private List <inquiry> inquiryList = new ArrayList<>();
	
	/**
	 * get all the inquiry details
	 * @return
	 */
	public List<inquiry> getAll(){
		
		List<inquiry> inquiry = getInquiryFromDb();
		
		return inquiry;
	}

	/**
	 * get all inquiries from the database
	 * @return
	 */

	public List<inquiry> getInquiryFromDb(){
	
	Connection connection = DbConnection.getInstance().getConnection();
	List<inquiry> inquiryList = new ArrayList<>();
	
	String sql = "SELECT * FROM `inquiry`;";
	
	try {
    
	  PreparedStatement stmt = connection.prepareStatement(sql);
	  ResultSet resultSet = stmt.executeQuery();
					
		while(resultSet.next()) {
			inquiry Inquiry = new inquiry();
			Inquiry.setInquiry_id (resultSet.getInt("inquiry_id"));
			Inquiry.setEmail(resultSet.getString("email"));
			Inquiry.setDesc(resultSet.getString("inquiry_desc"));
			
		inquiryList.add(Inquiry);
		}
		
		return inquiryList;
		
		} catch (Exception e) {
			logger.error("DB ERROR :  Could not access data - "+e.getMessage());
			return null;
	}
}

	
	public int addInquiry(inquiry inquiry) {
		
		Connection connection = DbConnection.getInstance().getConnection();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String sql = "INSERT INTO `inquiry` ( `email`,`inquiry_desc`)"
					+ "VALUES (?, ?);";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, inquiry.getEmail());
			stmt.setString(2, inquiry.getDesc());
		
			int res = stmt.executeUpdate();
			
			return res;
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("SQL ERROR :  Could not add your inquiry. - "+e.getMessage());
			return -1;
		}
	}

	
}
