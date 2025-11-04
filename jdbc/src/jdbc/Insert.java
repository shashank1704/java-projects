package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {

	public static void main(String[] args) 
	{
		try {
			// TODO Auto-generated method stub
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2", "c##shashank", "shashank");
			
			//create statement
			
			CallableStatement cstmt = con.prepareCall("call insertpro(?,?,?)");
			
			//set values
			/*cstmt.setInt(1,Integer.parseInt(args[0]));
			cstmt.setString(2, args[1]);
			cstmt.setInt(3, Integer.parseInt(args[3])); */
			
			//set values
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter rollno: ");
			int roll = sc.nextInt();
			
			System.out.print("Enter name: ");
			String name = sc.next();
			
			System.out.print("Enter marks: ");
			int marks = sc.nextInt();
			
			cstmt.setInt(1, roll);
			cstmt.setString(2, name);
			cstmt.setInt(3, marks);
			
			cstmt.execute();
			
			
			
			cstmt.executeUpdate();
			System.out.println("record inserted!!");
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("driver not loaded");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql query incorrect!");
			e.printStackTrace();
		}
		
		
	}

}
