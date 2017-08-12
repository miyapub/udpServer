package udpServer;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class mServer {
	final static int RECEIVE_LENGTH = 1024;  
	  
    static String multicastHost="224.0.0.1";  

    static int localPort = 8888;  

    public static void main(String[] args) throws Exception {  

                

              InetAddress receiveAddress =InetAddress.getByName(multicastHost);  

              if(!receiveAddress.isMulticastAddress()){//�����Ƿ�Ϊ�ಥ��ַ  

                       throw new Exception("��ʹ�öಥ��ַ");  

              }  

              int port = localPort;  

              MulticastSocket receiveMulticast = new MulticastSocket(port);  

              receiveMulticast.joinGroup(receiveAddress);  
              
              while(true){
            	  DatagramPacket dp = new DatagramPacket(new byte[RECEIVE_LENGTH], RECEIVE_LENGTH);  

                  receiveMulticast.receive(dp);  

                  System.out.println(new String(dp.getData()).trim());  
              }

              

              //receiveMulticast.close();  

    }  
}
