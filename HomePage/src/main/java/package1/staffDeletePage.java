package package1;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "R2", urlPatterns = {"/staffDeletePage"})
public class staffDeletePage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
    String checkProductID = request.getParameter("checkProductID");
    String productID = null;
    String productName = null;
    String productPrice = null;
    String productDesc = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/capt_empire", "root", "root");

        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM PRODUCTDETAILS";
        ResultSet rs = stmt.executeQuery(sql);

        boolean check = false;

        while (rs.next()) {
            productID = rs.getString("PRODUCTID");
            productName = rs.getString("PRODUCTNAME");
            productPrice = rs.getString("PRODUCTPRICE");
            productDesc = rs.getString("PRODUCTDESC");

            if (productID.equalsIgnoreCase(checkProductID)) {
                check = true;
                break;
            }
        }
        
        if(check == true) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"ISO-8859-1\">");
            out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Delete Product | Staff</title>");
            out.println("<link rel=\"stylesheet\" href=\"style.css\">");
            out.println("<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>");
            out.println("<link rel=\"icon\" href=\"data:image/png;base64,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\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<header class=\"navHeader\">");
            out.println("<a href=\"mainHome.html\" class=\"navLogo\">CaptEmpire</a>");
            out.println("<nav class=\"navbar\">");
            out.println("<input type=\"checkbox\" id=\"navbarCheck\">");
            out.println("<label for=\"navbarCheck\" class=\"navbarCheckbtn\">");
            out.println("<i class='bx bx-menu'></i>");
            out.println("</label>");
            out.println("<ul class=\"navbarMenu\">");
            out.println("<li><a href=\"mainHome.html\" class=\"active\">Home</a></li>");
            out.println("<li><a href=\"aboutUs.html\">About</a></li>");
            out.println("<li><a href=\"contact.html\">Contact</a></li>");
            out.println("<li><a href=\"#\">FAQs</a></li>");
            out.println("</ul>");
            out.println("</nav>");
            out.println("</header>");
            out.println("<section class=\"backgroundWebsite\">");
            out.println("<div class=\"staffForm-wrapper\">");
            out.println("<div class=\"staffForm-form-box-register\">");
            out.println("<h2>Delete Info</h2>");
            out.println("<h6>Data Deleted Successfully</h6>");
            out.println("<div class=\"staffForm-input-box\">");
            out.println("<input type=\"text\" name=\"productID\" value=\"ID: " + productID + "\" readonly>");
            out.println("</div>");
            out.println("<div class=\"staffForm-input-box\">");
            out.println("<input type=\"text\" name=\"productName\" value=\"Name: " + productName + "\" readonly>");
            out.println("</div>");
            out.println("<div class=\"staffForm-input-box\">");
            out.println("<input type=\"text\" name=\"productPrice\" value=\"Price: " + productPrice + "\" readonly>");
            out.println("</div>");
            out.println("<div class=\"staffForm-input-box\">");
            out.println("<input type=\"text\" name=\"productDesc\" value=\"Description: " + productDesc + "\" readonly>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</section>");
            out.println("</body>");
            out.println("</html>");
        } else {
            response.sendRedirect("staffDeletePage.jsp");
        }

    } catch (Exception e2) {
        System.out.println(e2);
    }

    out.close();
}
}
