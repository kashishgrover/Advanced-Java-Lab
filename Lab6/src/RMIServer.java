
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;

public class RMIServer {

    public static void main(String args[]) {
        try {
            Adder stub = new AdderRemote();
            Naming.rebind("rmi://localhost:1234/calc", stub);
        } catch (RemoteException | MalformedURLException e) {
            System.out.println(e);
        }
    }
}
