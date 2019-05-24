package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;

class DBConnection {
    
    private final static String usr = "";
    private final static String pwd = "";
	
	private static Connection conn;
	
	static {
		conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:8000:db01", usr, pwd);
			conn.setAutoCommit(true);
			System.out.println("Connect durchgefuehrt ....");
		} catch (Exception e) {
			System.err.println("Error while connecting to database");
			e.printStackTrace();
			System.exit(1);
		} 
	}
		
	protected static Connection getConnection() {
		return conn;
	}
}
