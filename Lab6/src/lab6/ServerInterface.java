package lab6;
import java.rmi.*;

/**
 *
 * @author Plankton
 */
public interface ServerInterface extends Remote{
    double add(double d1, double d2) throws RemoteException;
    double subtract(double d1, double d2) throws RemoteException;
    double multiply(double d1, double d2) throws RemoteException;
    double divide(double d1, double d2) throws RemoteException;
}
