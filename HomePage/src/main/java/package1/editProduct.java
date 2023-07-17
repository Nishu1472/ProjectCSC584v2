package package1;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "R4", urlPatterns = {"/editProduct"})
public class editProduct extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String productID = request.getParameter("productID");
        String productName = request.getParameter("productName");
        String productPrice = request.getParameter("productPrice");
        String productDesc = request.getParameter("productDesc");
        
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/capt_empire", "root", "admin");

            String sql = "UPDATE PRODUCTDETAILS SET PRODUCTID=?,PRODUCTNAME=?,PRODUCTPRICE=?,PRODUCTDESC=? WHERE NAME = '"+productID+"'";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,productID);
            ps.setString(2,productName);
            ps.setString(3,productPrice);
            ps.setString(4,productDesc);
            ps.executeUpdate();
            
            response.sendRedirect("staffDashboard.jsp");
        }catch (Exception e2) {
        	System.out.println(e2);
        }
    out.close();
}
}