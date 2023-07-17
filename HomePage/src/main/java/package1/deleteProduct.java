package package1;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "R3", urlPatterns = {"/deleteProduct"})
public class deleteProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
    String checkProductID = request.getParameter("productID");
    
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/capt_empire", "root", "admin");

        Statement stmt = con.createStatement();
        String sql = "DELETE FROM PRODUCTDETAILS WHERE PRODUCTID = '"+checkProductID+"'";
        stmt.executeUpdate(sql);
        
		response.sendRedirect("staffDeletePage.jsp");
        
        } catch (Exception e2) {
            System.out.println(e2);
        }
        out.close();
    }
}
