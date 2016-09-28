package Calculator_RMI;

import java.rmi.*;
import java.rmi.server.*;

/**
 *
 * @author Plankton
 */
public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {
    public ServerImplementation() throws RemoteException {}

    public double add(double d1, double d2) throws RemoteException {
        return d1 + d2;
    }

    public double subtract(double d1, double d2) throws RemoteException {
        return d1 - d2;
    }

    public double multiply(double d1, double d2) throws RemoteException {
        return d1 * d2;
    }

    public double divide(double d1, double d2) throws RemoteException {
        return d1 / d2;
    }
    
    public double sin(double d) throws RemoteException {
        return Math.sin(d);
    }
    
    public double cos(double d) throws RemoteException {
        return Math.cos(d);
    }
}
