package lab5;

import java.net.*;
import java.util.Scanner;

public class UDPClient {

    static Scanner sc = new Scanner(System.in);

    static byte[] data = new byte[10240];

    static String sentence;

    public static void main(String args[]) throws Exception {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            do {
                InetAddress IPAddress = InetAddress.getByName("localhost");

                System.out.print("Client: ");
                sentence = sc.nextLine();
                if(sentence.equals("stop"))
                {
                    clientSocket.disconnect();
                    clientSocket.close();
                    break;
                }
                data = sentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, 1234);
                clientSocket.send(sendPacket);
                
                DatagramPacket receivePacket = new DatagramPacket(data, data.length);
                clientSocket.receive(receivePacket);
                sentence = new String(receivePacket.getData());
                if(sentence.equals("stop"))
                    clientSocket.disconnect();
                System.out.println("Server: " + sentence);
            } while (!"stop".equals(sentence));
        }
    }
}
