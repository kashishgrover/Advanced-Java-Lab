/*
 * Write a program to demonstrate use of URL Connection class and Inet Address 
 * class for communication.
 */

import java.io.*;
import java.net.*;

/**
 *
 * @author Plankton
 */
public class URLConnectionReader {

    public static void main(String[] args) throws Exception {
        URL oracle = new URL("http://kashishgrover.com/");
        URLConnection yc = oracle.openConnection();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
