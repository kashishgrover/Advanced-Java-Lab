package lab6;

import java.rmi.*;
import java.rmi.server.*;

/**
 *
 * @author Plankton
 */
public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {
    public ServerImplementation() throws RemoteException {    }

    @Override
    public double add(double d1, double d2) throws RemoteException {
        return d1 + d2;
    }

    @Override
    public double subtract(double d1, double d2) throws RemoteException {
        return d1 - d2;
    }

    @Override
    public double multiply(double d1, double d2) throws RemoteException {
        return d1 * d2;
    }

    @Override
    public double divide(double d1, double d2) throws RemoteException {
        return d1 / d2;
    }
}
