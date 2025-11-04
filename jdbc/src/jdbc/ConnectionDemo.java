package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDemo {
    public static void main(String[] args) 
    {
        try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl2";
			
			Connection con = DriverManager.getConnection(url,"c##shashank","shashank");
			
			System.out.println("Connection established");
	
		
			
			 
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Driver not loaded!!!");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Not connected to database.");
			e.printStackTrace();
		}
    }
}
