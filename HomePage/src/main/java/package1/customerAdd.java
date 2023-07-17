package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="R7", urlPatterns={"/customerAdd"})
public class customerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("custname");
		String username = request.getParameter("custusername");
		String password = request.getParameter("custpassword");
		String email = request.getParameter("custemail");
		String phonenumber = request.getParameter("custphonenum");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdetails", "root", "root");
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO custdetails VALUES (?,?,?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, email);
			ps.setString(5, phonenumber);
			
			ps.executeUpdate();
			
			response.sendRedirect("staffDashboard.jsp");
			
		}catch (Exception e2) {
			System.out.println(e2);
		}
		out.close();
	}
}
