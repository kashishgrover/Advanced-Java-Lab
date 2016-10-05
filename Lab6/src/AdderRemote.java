import java.rmi.*;
import java.rmi.server.*;

public class AdderRemote extends UnicastRemoteObject implements Adder {

    private static final long serialVersionUID = 1L;

    AdderRemote() throws RemoteException {
        super();
    }

    @Override
    public double add(double x, double y) {
        return x + y;
    }

    @Override
    public double subtract(double x, double y) {
        return x - y;
    }

    @Override
    public double multiply(double x, double y) {
        return x * y;
    }

    @Override
    public double divide(double x, double y) {
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    @Override
    public int compare(String a, String b) throws RemoteException {
        int x = 0, y = 0;
        if (a.length() > b.length()) {
            return 1;
        } else if (a.length() < b.length()) {
            return -1;
        } else {
            for (int i = 0; i < a.length(); i++) {
                x = (int) a.charAt(i);
                y = (int) b.charAt(i);
                if (x > y) {
                    return 1;
                } else if (x < y) {
                    return -1;
                }
            }
        }
        return 0;
    }

    @Override
    public String reverse(String a) throws RemoteException {
        String result = "";
        result = new StringBuilder(a).reverse().toString();
        return result;
    }
}
