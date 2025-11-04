package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RSDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// TODO Auto-generated method stub
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2", "c##shashank", "shashank");
			
			//create statement
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT * FROM student10");
			
		
			rs.absolute(2);
			
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getInt(3)+"\t");
			
			
			
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Connection not established");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Incorrect query");
			e.printStackTrace();
		}

	}

}
