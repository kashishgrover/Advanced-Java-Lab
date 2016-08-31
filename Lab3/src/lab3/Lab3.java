/*
 - Develop an application for a bank.
 - The user will have the provision to register for the application.
 - Once registered and approved by the admin,the user should be able to log in using his or her credentials.
 - Consider the scenario of not less than 10 users, and each one should be able to see their balance.
 - In case of any transaction made to any other account, show the current balance in the account after the transaction.
 - The admin should have the provision to block or freeze any account in case of any emergencies.
 - The user should have a provision to see their transactions based on the selected dates. 
 */
package lab3;

import java.util.Scanner;

/**
 *
 * @author Plankton
 */
class User {

    String name;
    String username;
    String password;
    double balance;

    User(String name, String username, String password, double balance) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
    
    void addMoney() {
        
    }
    
    void withdrawMoney() {
        
    }            
}

public class Lab3 {

    static Scanner sc = new Scanner(System.in);
    static int choice = 0;
    static User U;
    static String name;
    static double salary;
    static double meow;

    public static void main(String[] args) {
        while (true) {
            System.out.println("MENU");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    
                    break;
                }
                case 2: {
                    System.out.println("Enter Name - ");
                    System.out.println("Enter Username - ");
                    System.out.println("Enter Password - ");
                    //U = new User();
                    break;
                }
                case 3:
                    System.exit(0);
            }
        }
    }
}
