/*
Define a class employee.
Every employee must have a name and a salary.
A parameterized constructors inits the name and the initial salary.
The method salaryChange(amount) must either increase or decrease salary by specified amount.
Method quit must set salary of employee to zero.
Method getInfo would return current salary of employee.
User must be able to instantiate employee objects and call any of the provided methods.
After each user command, the program must print the current salary of the employee. 
 */
package Employee;

import java.util.Scanner;

/**
 *
 * @author Plankton
 */
public class Employee {
    
    static String name;
    static double salary;
    
    Employee(String name, double salary)
    {
        Employee.name = name;
        Employee.salary = salary;
    }
    
    void salaryChange(double amount)
    {
        Employee.salary += amount;
    }
    
    void quit()
    {
        Employee.salary = 0.0;
    }
    
    double getInfo()
    {
        return Employee.salary;
    }
}

class EmployeeTest {    
    
    static Scanner sc = new Scanner(System.in);    
    static int choice=0;
    static Employee E;
    static String name;
    static double salary;
    static double meow;
    
    public static void main(String[] args)
    {
	while(true)
	{
            System.out.println("MENU");
            System.out.println("1. New Employee");
            System.out.println("2. View Salary");
            System.out.println("3. Give Increment/Decrement");
            System.out.println("4. Fire Employee");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1: {
                    System.out.println("Enter Name of New Employee - ");
                    name = sc.next();
                    System.out.println("Enter Salary of New Employee - ");
                    salary = sc.nextDouble();
                    E = new Employee(name,salary);
                    break;
                }
                case 2: {
                    System.out.println("Salary: "+ E.getInfo());                    
                    break;
                }
                case 3: {
                    System.out.println("Enter Increment/Decrement - ");
                    meow = sc.nextDouble();
                    E.salaryChange(meow);               
                    break;
                }
                case 4: {
                    E.quit();              
                    break;
                }
                case 5: System.exit(0);
            }
        }
    }
}