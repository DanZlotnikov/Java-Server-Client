import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class dbActions {
	
	// Connects to a local db 
	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Israel";
			String username = "root";
			String password = "123456";
			//DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			//Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected database successfully!");
			
			return conn;
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
	public static void dbInsert(HashMap<String, String> data)
	{
		String hebrewName = data.get("usernameHebrew");
		String englishName = data.get("usernameEnglish");
		String city = data.get("city");
		String street = data.get("street");
		int stNumber;
		try {
			 stNumber = Integer.parseInt(data.get("stNumber"));
		}
		catch(Exception e) {stNumber = 0;}
		
		String phone = data.get("phone");
		int activeCode = Integer.parseInt(data.get("activeCode"));
		
		if (hebrewName == "")
			hebrewName = "-";
		
		if (englishName == "")
			englishName = "-";
		
		if (city== "")
			city = "-";
		
		if (street == "")
			street = "-";
		
		if (phone == "")
			phone = "-";
		
		
		Date dNow = new Date();
	      SimpleDateFormat ft = 
	      new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
	    
	    String modificationDate = ft.format(dNow);
	    
	    Connection conn = null;
		Statement stmt = null;
		   try{

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = getConnection();
		      
		      //STEP 4: Execute a query
		      System.out.println("Inserting records into the table...");
		      stmt = conn.createStatement();
		      
		      String sql = "insert into customers(hebrewName, englishName, city, street, stNumber, phone, activeCode, modificationDate)\r\n" + 
		      		String.format("values ('%1$s', '%2$s', '%3$s', '%4$s', %5$d, '%6$s', %7$d, '%8$s');", hebrewName, englishName, city, street, stNumber, phone, activeCode, modificationDate);
		      stmt.executeUpdate(sql);
		      System.out.println("Inserted records into the table!");

		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		
	}

	public static void dbUpdate(int id, HashMap<String, String> data)
	{
		String hebrewName = data.get("usernameHebrew");
		String englishName = data.get("usernameEnglish");
		String city = data.get("city");
		String street = data.get("street");
		int stNumber;
		try {
			 stNumber = Integer.parseInt(data.get("stNumber"));
			}
		catch(Exception e) {stNumber = Integer.MIN_VALUE;}
		
		String phone = data.get("phone");
		int activeCode = Integer.parseInt(data.get("activeCode"));
		
		Date dNow = new Date();
	      SimpleDateFormat ft = 
	      new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
	    
	    String modificationDate = ft.format(dNow);
	    
	    Connection conn = null;
		Statement stmt = null;
		   try{

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = getConnection();
		      
		      //STEP 4: Execute a query
		      System.out.println("Updating records...");
		      stmt = conn.createStatement();
		      String sql = "update customers set ";
		      if (!hebrewName.equals(""))
		      {
		    	  sql += "hebrewName = " + "'" + hebrewName + "', ";
		      }
		      
		      if (!englishName.equals(""))
		      {
		    	  sql += "englishName = " + "'" + englishName + "', ";
		      }
		      
		      if (!city.equals(""))
		      {
		    	  sql += "city = " + "'" + city + "', ";
		      }
		      
		      if (!street.equals(""))
		      {
		    	  sql += "street = " + "'" + street + "', ";
		      }
		      
		      if (stNumber != Integer.MIN_VALUE)
		      {
		    	  sql += "stNumber = " + stNumber + ", ";
		      }
		      
		      if (!phone.equals(""))
		      {
		    	  sql += "phone = " + "'" + phone + "', ";
		      }
		      
		      sql += "activeCode = " + "'" + activeCode + "', ";
		      
		      sql += "modificationDate = " + "'" + modificationDate + "' ";
		      
		      sql += "where id = " + id;
		      
		      stmt.executeUpdate(sql);
		      System.out.println("Updated records!");

		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		
	}
}
