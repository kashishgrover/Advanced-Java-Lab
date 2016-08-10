package ExceptionHandling;

import java.util.*;

class ArrayIndexOutOfBoundsExceptionTest {

    public static void main(String ar[]) {
        Scanner in = new Scanner(System.in);

        int a[] = new int[5], n, i = 0;

        System.out.println("Max no of elements = 5");

        try {

            System.out.println("Enter the elements");
            char ch = 'n';
            do {
                a[i] = in.nextInt();
                i++;
                System.out.print("Enter another? (y/Y)");
                ch = in.next().charAt(0);
            } while (ch == 'y' || ch == 'Y');

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception " + e);
        } finally {
            System.out.println("ARRAY ENTERED:");

            for (i = 0; i < 5; i++) {
                System.out.println(a[i]);
            }

            System.out.print("Enter key - ");
            int key = in.nextInt();

            int flag = 0;

            for (i = 0; i < 5; i++) {
                if (key == a[i]) {
                    System.out.println("Key found at " + i + " position!");
                    flag = 1;
                }
            }
            if (flag == 0) {
                System.out.println("Not found!");
            }
        }

    }
}
