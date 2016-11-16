/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kashish
 */
public class MenuServlet extends HttpServlet {
    
    static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost:3306/Employee";
    static String USER = "kashish";
    static String PASS = "Zildjian1";
    
    static Connection con;
    static PreparedStatement ps;

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");        
        String id = request.getParameter("id");
        String pass = request.getParameter("password");
        PrintWriter out = response.getWriter();
        
        boolean st =false;
        try {
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            ps = (PreparedStatement) con.prepareStatement("select * from admin"
                    + " where id=? and password=?");
            ps.setString(1, id);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        }catch(ClassNotFoundException | SQLException e)
        {
            out.println(e.getMessage()+"\n");
        }
        
        if(st)
        {
            RequestDispatcher rs = request.getRequestDispatcher("/Menu.html");
            rs.forward(request, response);
        }
        else
        {
           out.println("Username or Password incorrect "+ id + " " + pass);
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
               
        out.println("</html>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
