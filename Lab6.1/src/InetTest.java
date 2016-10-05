/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Plankton
 */
import java.net.*;

public class InetTest {

    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("http://kashishgrover.com");

            System.out.println("Host Name: " + ip.getHostName());
            System.out.println("IP Address: " + ip.getHostAddress());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
