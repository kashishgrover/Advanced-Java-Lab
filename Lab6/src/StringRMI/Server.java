package StringRMI;

import java.net.MalformedURLException;
import java.rmi.*;

/**
 *
 * @author Plankton
 */
public class Server {
    public static void main(String args[]) {
        try {
            ServerImplementation server = new ServerImplementation();
            Naming.rebind("CalculatorServer", server);
        } catch (RemoteException | MalformedURLException e) {
            System.out.println("Exception: " + e);
        }
    }
}
