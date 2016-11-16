/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kashish
 */
public class AllEmployeeServlet extends HttpServlet {

    static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost:3306/Employee";
    static String USER = "kashish";
    static String PASSWORD = "Zildjian1";
    
    static Connection conn;
    static Statement stmt;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASSWORD);
        stmt = (Statement) conn.createStatement();
        
        String query = "select * from Employee;";
        ResultSet rs = stmt.executeQuery(query);
        PrintWriter out = response.getWriter();
        
        try{
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>All Employees</title>");            
            out.println("</head>");
            out.println("<body><center>");
            out.println("<h1>List of all Employees</h1><br><br><table border='1'"
                    + " cellpadding='5'>");
            out.println("<tr><th>NAME</th><th>EMAIL</th><th>DEPT</th></tr>");
            while(rs.next())
            {
                out.println("<tr>");
                out.println("<td>"+rs.getString("name")+"</td>");
                out.println("<td>"+rs.getString("email")+"</td>");
                out.println("<td>"+rs.getString("department")+"</td>");
                out.println("</tr>");
            }
            out.println("</table></center></body>");
            out.println("</html>");
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AllEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AllEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
