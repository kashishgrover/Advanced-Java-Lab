package Calculator_RMI;

/**
 *
 * @author Plankton
 */
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.Scanner;

public class Client {

    static Scanner sc = new Scanner(System.in);
    static int choice;

    public static void main(String args[]) {
        try {
            String ServerURL = "rmi://localhost/CalculatorServer";
            ServerInterface serverInt = (ServerInterface) Naming.lookup(ServerURL);
            do {
                System.out.print("Enter Choice:\n1>ADD\n2>SUBTRACT\n3>MULTIPLY\n4>DIVIDE\n5>Sin(x)\n6>Cos(x)\n0>EXIT");
                choice = sc.nextInt();
                if (choice == 1) {
                    System.out.print("Enter First Number: ");
                    double num1 = sc.nextDouble();
                    System.out.print("Enter Second Number: ");
                    double num2 = sc.nextDouble();
                    System.out.println("The sum is: " + serverInt.add(num1, num2));
                } else if (choice == 2) {
                    System.out.print("Enter First Number: ");
                    double num1 = sc.nextDouble();
                    System.out.print("Enter Second Number: ");
                    double num2 = sc.nextDouble();
                    System.out.println("The difference is: " + serverInt.subtract(num1, num2));
                } else if (choice == 3) {
                    System.out.print("Enter First Number: ");
                    double num1 = sc.nextDouble();
                    System.out.print("Enter Second Number: ");
                    double num2 = sc.nextDouble();
                    System.out.println("The product is: " + serverInt.multiply(num1, num2));
                } else if (choice == 4) {
                    System.out.print("Enter First Number: ");
                    double num1 = sc.nextDouble();
                    System.out.print("Enter Second Number: ");
                    double num2 = sc.nextDouble();
                    System.out.println("The product is: " + serverInt.multiply(num1, num2));
                } else if (choice == 5) {
                    System.out.print("Enter Value: ");
                    double val = sc.nextDouble();
                    System.out.println("The Sine is: " + serverInt.sin(val));
                } else if (choice == 6) {
                    System.out.print("Enter Value: ");
                    double val = sc.nextDouble();
                    System.out.println("The Cos is: " + serverInt.cos(val));
                } else if (choice == 0) {
                    break;
                }
            } while (choice >= 0 && choice <= 6);
        } catch (NotBoundException | MalformedURLException | RemoteException | NumberFormatException e) {
            System.out.println("Exception: " + e);
        }
    }
}
