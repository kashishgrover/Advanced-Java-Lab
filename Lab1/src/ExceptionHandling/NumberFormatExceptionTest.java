package ExceptionHandling;

import java.util.*;

class NumberFormatExceptionTest {

    public static void main(String ar[]) {
        Scanner in = new Scanner(System.in);

        String s;
        int n = 0;

        System.out.println("Enter a string");

        s = in.next();

        try {
            n = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception Occured");
            n = 0;
        } finally {
            System.out.println("\nAfter converting : \n\n" + n);
        }
    }
}
