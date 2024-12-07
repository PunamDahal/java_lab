import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DatabaseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            
            out.println("<html><body>");
            while (rs.next()) {
                out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + "<br>");
            }
            out.println("</body></html>");
            
        } catch (Exception e) {
            out.println("Database connection error");
            e.printStackTrace();
        }
    }
}
