package com.tourism_org.com.tourismapp.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.mysql.cj.jdbc.Driver;

public class DbConnection {
	
<<<<<<< HEAD
	private static Logger logger = LogManager.getLogger(DbConnection.class);
=======
//	private static Logger logger = LogManager.getLogger(DbConnection.class);
>>>>>>> cb602b23991c4fd6718740ad386f667e2cfb45b5
//	private static final String DB_URL="jdbc:mysql://localhost:3306/tourismapp";
//	private static final String DB_USER="root";
//	private static final String DB_PASSWORD ="12345";

//	private static final String DB_URL="jdbc:mysql://us-cdbr-east-04.cleardb.com/heroku_8948ce830834efe";
//	private static final String DB_USER="baca4251f43b6a";
//	private static final String DB_PASSWORD ="4942cd07";
	
	private static final String DB_URL="jdbc:mysql://us-cdbr-east-04.cleardb.com/heroku_8948ce830834efe";
	private static final String DB_USER="baca4251f43b6a"; 
	private static final String DB_PASSWORD ="4942cd07";

	private static final String DB_URL="jdbc:mysql://us-cdbr-east-04.cleardb.com/heroku_779b0e65ed1f1db";
	private static final String DB_USER="b6e92ff63b9fce";
	private static final String DB_PASSWORD ="4df5cc3f";
	
	private static DbConnection newInstance = null;

	private DbConnection() {

}

public static DbConnection getInstance() {
	if (newInstance == null) {
		newInstance = new DbConnection();
	}
	
	return newInstance;
}

public Connection getConnection() {
  	try {
  				Driver driver =new Driver();
  				DriverManager.registerDriver(driver);
  				
  				Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);  				
  				logger.info("DB SUCCESS :  Connection Successful");
  				return conn;			
  				
  			} catch (SQLException e) {
  				e.printStackTrace();
  				logger.error(e.hashCode()+" DB ERROR :  Connection failed - "+e.getMessage());
  				return null;
  			}
  			
  		}

  	}
