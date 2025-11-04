package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection  con;
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2", "c##shashank", "shashank");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String s1 = request.getParameter("username");
			String s2 = request.getParameter("password");
			PreparedStatement pstmt = con.prepareStatement("select * from userinfo where username=? and password=?");
			pstmt.setString(1, s1);
			pstmt.setString(2, s2);
			ResultSet rs = pstmt.executeQuery();
			PrintWriter pw = response.getWriter();
			if(rs.next())
			{
				pw.println("<html><body><br><br><h1 align=center style=color:green>");
				pw.println("Welcome "+s1);
				pw.println("</h1></body></html>");
			}
			else
			{
				pw.println("<html><body><br><br><h1 align=center style=color:red>");
				pw.println("Invalid username or Password");
				pw.println("</h1></body></html>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
