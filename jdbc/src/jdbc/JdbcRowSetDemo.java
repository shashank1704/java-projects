package jdbc;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class JdbcRowSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			JdbcRowSet jrs = new OracleJDBCRowSet();
			jrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl2");
			jrs.setUsername("c##shashank");
			jrs.setPassword("shashank");
			
			jrs.setCommand("SELECT * FROM student10");
			jrs.execute();
			
			while(jrs.next())
			{
				System.out.print(jrs.getInt(1)+"\t");
				System.out.print(jrs.getString(2)+"\t");
				System.out.println(jrs.getInt(3));
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
