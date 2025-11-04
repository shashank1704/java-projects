package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class SelectDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl2";
			
			Connection con = DriverManager.getConnection(url,"c##shashank", "shashank");

			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM student10");
			
			ResultSetMetaData rm = rs.getMetaData();
			
			int n = rm.getColumnCount();
			
			for(int i=1; i<=n; i++)
			{
				String s = rm.getColumnName(i);
				System.out.print(s+"\t");
			}
			System.out.println();
			
			while(rs.next())
			{
				for(int i=1; i<=n; i++)
				{
					String s = rs.getString(i);
					System.out.print(s+"\t");
				}
				System.out.println();
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		
		
	}

}
