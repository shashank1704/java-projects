package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BSDemo {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2", "c##shashank", "shashank");

			PreparedStatement pstmt = con.prepareStatement("INSERT INTO images VALUES(?, ?)");
				
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter image name");
			String image = sc.next();
			System.out.print("Enter file path");
			String path = sc.next();
			
			
			pstmt.setString(1, image);
			FileInputStream fis = new FileInputStream(path);
			pstmt.setBinaryStream(2, fis, fis.available());
			
			pstmt.executeUpdate();
			
			System.out.println("One image inserted");
		
		
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
