package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","c##shashank", "shashank");
			
			Statement stmt = con.createStatement();
			
			stmt.addBatch("INSERT INTO student10 VALUES(4,'venkey', 78)");
			stmt.addBatch("INSERT INTO student10 VALUES(5,'ramu', 85)");
			stmt.addBatch("UPDATE student10 SET marks=99 WHERE rollno=1");
			
			stmt.executeBatch();
			
			System.out.println("Batch executed!");
		
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
