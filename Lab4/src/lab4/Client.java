package lab4;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 1234;
        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());

            String message;
            do {
                System.out.print("Client: ");
                message = sc.nextLine();
                OutputStream outToServer = client.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToServer);
                out.writeUTF(message);

                InputStream inFromServer = client.getInputStream();
                DataInputStream in = new DataInputStream(inFromServer);
                System.out.println("Server: " + in.readUTF());
            } while (!"stop".equals(message));
        } catch (Exception e) {
        }
    }
}
