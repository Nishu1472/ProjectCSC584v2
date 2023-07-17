package package1;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "R6", urlPatterns = {"/customerCheck"})
public class customerCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String checkUsername = request.getParameter("custusername");
	String checkPassword = request.getParameter("custpassword");
	boolean check = false;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdetails", "root", "root");
		
		Statement stmt = con.createStatement();
		String sql = "SELECT * FROM CUSTDETAILS";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			String username = rs.getString("CUSTUSERNAME");
			String password = rs.getString("CUSTPASSWORD");
			
			if(username.equalsIgnoreCase(checkUsername) && password.equalsIgnoreCase(checkPassword)) 
			{
			check = true;
			}
		}
		
		if (check == true)
			response.sendRedirect("staffDashboard.jsp");
		
		else if (check == false)
			response.sendRedirect("custLoginReg.jsp");
	}
	catch(Exception e2) {
		System.out.println(e2);
	}
	out.close();
	}	
}
