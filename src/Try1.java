import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Try1 {

	public static Connection getConnection() throws Exception {
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Israel";
			String username = "root";
			String password = "123456";
			//DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			//Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			
			return conn;
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	public static void main(String[] args) {
		   Connection conn = null;
		   Statement stmt = null;
		   try{

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = getConnection();
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Inserting records into the table...");
		      stmt = conn.createStatement();
		      
		      Date dNow = new Date();
		      SimpleDateFormat ft = 
		      new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		      String dateTime = ft.format(dNow);
		      
		      String sql = "select * from customers where id = 18";
		      ResultSet customers = stmt.executeQuery(sql);
		      if(customers.first())
		    	  System.out.println("yes");
		      
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
		}//end main

}
