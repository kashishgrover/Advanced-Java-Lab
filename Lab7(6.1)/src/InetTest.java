/**
 *
 * @author Plankton
 */
import java.net.*;

public class InetTest {

    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("https://facebook.com");

            System.out.println("Host Name: " + ip.getHostName());
            System.out.println("IP Address: " + ip.getHostAddress());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
