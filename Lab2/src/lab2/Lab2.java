/*
 Develop a complete login application.
 
 The application will ask the user to input username and password and to check
 the existence of this user in the database. 

 The username should consist of at least one symbol and one number.  

 While entering  the password, it should be masked with * or . symbol.

 There should be provision for the user to register for the particular application.
 
 If the user exists,  the retrieve the data based on the query. If not registered, display "Sorry, 
 you are not registered.".

 The above program has to be implemented to keep track of students, faculties and the 
 administrators in a college. The privileges given for each type of user should vary based on their designation.

To run this application from the command line without Ant, try:
java -jar "C:\Users\Plankton\Desktop\Advanced-Java-Lab\Lab2\dist\Lab2.jar"
 */
package lab2;

import java.io.Console;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Plankton
 **/
public class Lab2 {

    static final String USER = "root";
    static final String PASS = "student";
    static final String DB_URL = "jdbc:mysql://localhost:3306/student";
    
    static Connection conn;

    static ResultSet rs;
    static Statement stmt;
    
    static String user, pass, name = "", role = "";
    static int age = 0;

    static Scanner sc = new Scanner(System.in);
    static Console console = System.console();
    
    static PreparedStatement pstmt = null;

    public static void main(String[] args) {        

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...\n");
            
            stmt = conn.createStatement();
            pstmt = conn.prepareStatement("insert into student values(?,?,?,'Student')");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        int ch;
        System.out.println("Enter choice: \n1) Sign Up\n2) Sign In\n");
        ch = sc.nextInt();

        try {
            if (ch == 1) 
            {
                System.out.println("Enter Username: ");
                name = sc.next();
                String query = "select * from student";
                rs = stmt.executeQuery(query);
                int flag = 0;
                String temp;
                while (rs.next()) 
                {
                    temp = rs.getString("name");
                    if (name.equals(temp))
                    {
                        flag = 1;
                        break;
                    }
                }
                
                if (flag == 1) 
                {
                    System.out.println("User already exists! Try signing in.");
                }
                
                else 
                {
                    System.out.println("Password: ");
                    pass = sc.next();
                    System.out.println("Age: ");
                    age = sc.nextInt();
                    pstmt.setString(1, name);
                    pstmt.setString(2, pass);
                    pstmt.setInt(3, age);
                    pstmt.execute();
                    pstmt.close();
                }
                rs.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            if (ch == 2) {
                System.out.println("Username: ");
                user = sc.next();
                System.out.println("Password: ");
                String passw = new String(System.console().readPassword());

                String query = "select * from student";
                try (ResultSet rs2 = stmt.executeQuery(query)) {
                    int flag = 0;
                    while (rs2.next()) {
                        name = rs2.getString("name");
                        String pwd = rs2.getString("pass");
                        if (name.equals(user) && passw.equals(pwd)) {
                            flag = 1;
                            age = rs2.getInt("age");
                            role = rs2.getString("role");
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.println("Invalid Login!");
                        System.exit(0);
                    } else {
                        System.out.println("User found!");
                        System.out.println("Name: " + name);
                        System.out.println("Age: " + age);
                        System.out.println("Role: " + role);
                        switch (role) {
                            case "Admin":
                                System.out.println("You can:\n1)View Table.\n2)Enter record.\n");
                                break;
                            case "Student":
                                System.out.println("You can:\n1)View Table.\n");
                                break;
                        }
                    }
                }
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Goodbye!\n");
    }
}
