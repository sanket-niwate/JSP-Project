package sanket.niwate.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbcon {
static	Connection connection=null;
	
	public static Connection getConnection() {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			  System.out.println("JDBC Driver loaded successfully.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 System.out.println("Error: Unable to load JDBC Driver.");
		}
		
		try {
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_cart","root","Skt@5013");
			 System.out.println("Database connected successfully.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 System.out.println("Error: Unable to connect to the database.");
		}
		
		return connection;
		
		
		
	}
// private static Connection connection= null;
// 
// public static Connection getConnection() throws  SQLException, ClassNotFoundException {
//	 if (connection==null) {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_cart","root","Skt@5013");
//				
//	} else {
//		return connection;
//	}
//	return connection;
//	
//	
// }
}
