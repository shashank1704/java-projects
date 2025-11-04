package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl2";
			
			Connection con = DriverManager.getConnection(url,"c##shashank","shashank");
			
			System.out.println("Connection established");

			Statement stmt = con.createStatement();
			
			stmt.execute("create table student10(rollno number(3), name varchar2(10), marks number(3))");
			
			System.out.println("Table created successfully");
		
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
