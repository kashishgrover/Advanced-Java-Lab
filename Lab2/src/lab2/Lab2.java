/*
 Develop a complete login application. The application will ask the user to input username and password and to check the 
 existence of this user in the database. The username should consist of at least one symbol and one number.  While entering 
 the password, it should be masked with * or . symbol. There should be provision for the user to register for the 
 particular application. If the user exists,  the retrieve the data based on the query. If not registered, display "Sorry, 
 you are not registered.". The above program has to be implemented to keep track of students, faculties and the 
 administrators in a college. The privileges given for each type of user should vary based on their designation.
 */
package lab2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Plankton
 */
public class Lab2 {

    static final String USER = "root";
    static final String PASS = "student";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Lab2";
    static Connection conn;

    static String sql;
    static ResultSet rs;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Lab2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
