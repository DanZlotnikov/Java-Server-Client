import java.sql.Connection;
import java.sql.DriverManager;

public class Try {

	public static Connection getConnection() throws Exception {
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql//localhost:3306/myDB";
			String username = "root";
			String password = "123456";
			
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		getConnection();
	}

}
