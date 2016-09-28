/*
 * Write a program to demonstrate the Client-Server communication using TCP
 */
package lab4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Plankton
 */
public class Server extends Thread {

    static Scanner sc = new Scanner(System.in);

    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(100000);
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("Just connected to " + server.getRemoteSocketAddress());

                String message;
                do {
                    InputStream inFromServer = server.getInputStream();
                    DataInputStream in = new DataInputStream(inFromServer);
                    System.out.println("Client: " + in.readUTF());

                    System.out.print("Server: ");
                    message = sc.nextLine();
                    if(message.equals("stop"))
                        server.close();
                    OutputStream outToServer = server.getOutputStream();
                    DataOutputStream out = new DataOutputStream(outToServer);
                    out.writeUTF(message);
                } while (!"stop".equals(message));

            } catch (Exception e) {
                System.out.println("Socket timed out!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        int port = 1234;
        try {
            Thread t = new Server(port);
            t.start();
        } catch (IOException e) {
        }
    }
}
