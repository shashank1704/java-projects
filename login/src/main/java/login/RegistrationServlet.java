package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection con;
	public void init(ServletConfig config) throws ServletException {
		try {
			// TODO Auto-generated method stub
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2", "c##shashank", "shashank");
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
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
				String s1 = request.getParameter("fname");
				String s2 = request.getParameter("lname");
				String s3 = request.getParameter("username");
				String s4 = request.getParameter("password");
				
				PreparedStatement pstmt = con.prepareStatement("insert into userinfo values(?,?,?,?)");
				
				pstmt.setString(1, s1);
				pstmt.setString(2, s2);
				pstmt.setString(3, s3);
				pstmt.setString(4, s4);
				pstmt.executeUpdate();
				
				PrintWriter pw = response.getWriter();
				pw.println("<html><body><br><br><h1 align=center style=color:green>");
				pw.println("Registration successfull "+s1);
				pw.println("</h1></body></html>");
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
