import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(1234);
        byte[] receiveData = new byte[1024];
        
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);
        
        String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received: " + message);
        
        String response = "Hello from server";
        DatagramPacket sendPacket = new DatagramPacket(response.getBytes(), response.length(), 
                                                      receivePacket.getAddress(), receivePacket.getPort());
        socket.send(sendPacket);
    }
}
