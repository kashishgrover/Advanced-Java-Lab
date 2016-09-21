/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.net.*;
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
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
