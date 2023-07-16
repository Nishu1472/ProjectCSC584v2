package package1;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "R1", urlPatterns = {"/staffCheck"})
public class staffCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String checkUsername = request.getParameter("staffUsername");
	String checkPassword = request.getParameter("staffPassword");
	boolean check = false;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/capt_empire", "root", "admin");
		
		Statement stmt = con.createStatement();
		String sql = "SELECT * FROM STAFFDETAILS";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			String username = rs.getString("STAFFUSERNAME");
			String password = rs.getString("STAFFPASSWORD");
			
			if(username.equalsIgnoreCase(checkUsername) && password.equalsIgnoreCase(checkPassword))
			{
				check = true;
			}	
		}

		if (check == true)
			response.sendRedirect("staffDashboard.jsp");
		
		else if (check == false)
			response.sendRedirect("staffLogin.jsp");
		
	}catch (Exception e2) {
		System.out.println(e2);
	}
	out.close();
	}
}
