package ExceptionHandling;

//Program which handles Arithmetic Exception (division by 0)\
import java.util.Scanner;

class ArithmeticExceptionTest {

    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);
        int a, b, x = 0;

        System.out.println("DIVISION");
        System.out.print("Enter a number - ");
        a = sc.nextInt();
        System.out.print("Enter a number - ");
        b = sc.nextInt();

        try {
            x = a / b;
        } catch (ArithmeticException A) {
            System.out.println("Error");
        } finally {
            System.out.println("a/b=" + x);
        }
    }
}
