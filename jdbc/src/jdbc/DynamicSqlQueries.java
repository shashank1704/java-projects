package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;



//import java.sql.SQLException;

public class DynamicSqlQueries {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl2";
			
			Connection con = DriverManager.getConnection(url, "c##shashank", "shashank");
			
			PreparedStatement pstmt = con.prepareStatement("SELECT marks FROM student10 WHERE rollno=?");
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter the rollno: ");
			
			int r = sc.nextInt();
						
			pstmt.setInt(1, r);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			int m = rs.getInt(1);
			
			System.out.println(m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
