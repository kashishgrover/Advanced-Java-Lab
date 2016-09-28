package lab5;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPServer extends Thread {

    static Scanner sc = new Scanner(System.in);

    private final DatagramSocket serverSocket;

    public UDPServer(int port) throws IOException {
        serverSocket = new DatagramSocket(port);
        serverSocket.setSoTimeout(100000);
    }

    @Override
    public void run() {
        byte[] data = new byte[10240];
        String sentence;
        while (true) {
            try {
                do {
                    DatagramPacket receivePacket = new DatagramPacket(data, data.length);
                    serverSocket.receive(receivePacket);                    
                    sentence = new String(receivePacket.getData());
                    if(sentence.equals("stop"))
                        serverSocket.disconnect();
                    System.out.println("Client: " + sentence);
                    
                    InetAddress IPAddress = receivePacket.getAddress();
                    int port = receivePacket.getPort();
                    
                    System.out.print("Server: ");
                    sentence = sc.nextLine();
                    if(sentence.equals("stop"))
                        serverSocket.disconnect();
                    data = sentence.getBytes();                    
                    DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, port);
                    serverSocket.send(sendPacket);      
                } while (!"stop".equals(sentence));

            } catch (Exception e) {
                System.out.println("Socket timed out!");
                break;
            }
        }
    }

    public static void main(String args[]) throws Exception {
        int port = 1234;
        try {
            Thread t = new UDPServer(port);
            t.start();
        } catch (IOException e) {
        }
    }
}
