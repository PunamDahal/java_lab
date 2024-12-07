import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        String message = "Hello Server!";
        
        DatagramPacket sendPacket = new DatagramPacket(message.getBytes(), message.length(), 
                                                       InetAddress.getByName("localhost"), 1234);
        socket.send(sendPacket);
        
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);
        
        System.out.println("Received from server: " + new String(receivePacket.getData(), 0, receivePacket.getLength()));
    }
}
