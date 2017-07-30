package udpServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
 
public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8888);
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (true) {
            byte data[] = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            String result = new String(packet.getData(), packet.getOffset(), packet.getLength());
            System.out.println("receive client's data: " + result);
        }
    }
}