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

@WebServlet(name="R3", urlPatterns={"/customerAdd"})
public class customerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public customerAdd() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("custusername");
		String password = request.getParameter("custpassword");
		String email = request.getParameter("custemail");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/custdetails", "root", "root");
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO custdetails Values (?, ?, ?)");
			
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, email);
			
			int i = ps.executeUpdate();
			if(i>0)
				out.print("You have successfully registered");
		}catch (Exception e2) {
			System.out.println(e2);
		}
		out.close();
	}
}
