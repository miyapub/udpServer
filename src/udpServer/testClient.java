package udpServer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class testClient {
	
	public static void sendUdpMsg(String ip,int port,String msg) throws IOException{
        DatagramSocket socket = null;
        InetAddress serverAddress = InetAddress.getByName(ip);
        socket = new DatagramSocket(port);
        byte data[] = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, port);
        socket.send(packet);
        socket.close();
        System.out.println("ok");
    }
	public static void main(String[] args) throws IOException {
		sendUdpMsg("192.168.1.108",7777,"haha");
	}
	public static void sendTcpMsg(String ip,int port,String msg) throws UnknownHostException, IOException{
		Socket socket = null;
		socket = new Socket(ip, port);
		
        //发送给服务端的消息  

        try {  
            
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(msg);
            out.flush();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            //关闭Socket  
            try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            System.out.println("Client:Socket closed"+msg);  
        }  
	}
}
