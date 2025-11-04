package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class UpdateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url = "jdbc:oracle:thin:@localhost:1521:orcl2";
				
				Connection con = DriverManager.getConnection(url,"c##shashank","shashank");
				
				Statement stmt = con.createStatement();
				
				stmt.executeUpdate("insert into student10 values(4,'srinu', 86)");
				
				System.out.println("Values inserted successfully");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
