package jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

import oracle.jdbc.rowset.OracleWebRowSet;

public class WebRowSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			WebRowSet wrs = new OracleWebRowSet();
			wrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl2");
			wrs.setUsername("c##shashank");
			wrs.setPassword("shashank");
			
			wrs.setCommand("SELECT * FROM student10");
			wrs.execute();
			
			while(wrs.next())
			{
				System.out.print(wrs.getInt(1)+"\t");
				System.out.print(wrs.getString(2)+"\t");
				System.out.println(wrs.getInt(3));
			}
			FileOutputStream fos = new FileOutputStream("student10.xml");
			wrs.writeXml(fos);
			
			System.out.println();
			System.out.println("Xml file genarated!!");
		
		
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
