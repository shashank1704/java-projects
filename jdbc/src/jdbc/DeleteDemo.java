package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//Connection establishment
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2", "c##shashank", "shashank");
			
			//create statement
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM student10 WHERE rollno=?");
			
			//read roll no
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter roll no: ");
			int roll = sc.nextInt();
			
			//set roll no
			pstmt.setInt(1, roll);
			pstmt.executeUpdate();
			
			//display message
			System.out.println("One record deleted!!");
	
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
