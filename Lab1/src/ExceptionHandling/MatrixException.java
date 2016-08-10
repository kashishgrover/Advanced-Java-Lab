package ExceptionHandling;

import java.util.Scanner;

class MatrixException extends Exception {

    @Override
    public String toString() {
        return "This is not a matrix!! ";
    }
}

class NegativeRootException extends Exception {

    @Override
    public String toString() {
        return "Cannot compute root of a negative number!";
    }
}

class Matrix {

    int row, column;

    public void Mat() {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter number of rows and columns: ");
        row = obj.nextInt();
        column = obj.nextInt();
        try {
            if (row != column) {
                throw new MatrixException();
            } else {
                System.out.println("Valid matrix.");
            }
        } catch (MatrixException e) {
            System.out.println(e.toString());
        }
    }
}

class Root {

    public void compute(int n) {
        try {
            if (n < 0) {
                throw new NegativeRootException();
            } else {
                System.out.println("Root of " + n + " is " + Math.sqrt(n));
            }
        } catch (NegativeRootException r) {
            System.out.println(r.toString());
        }
    }
}

class body {

    public static void main(String args[]) {
        Matrix obj1 = new Matrix();
        obj1.Mat();
        Root obj2 = new Root();
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter number to compute root of: ");
        obj2.compute(obj.nextInt());
    }
}
