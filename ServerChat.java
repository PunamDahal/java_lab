import java.io.*;
import java.net.*;

public class ServerChat {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket clientSocket = serverSocket.accept();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        
        String message;
        while ((message = reader.readLine()) != null) {
            System.out.println("Client: " + message);
            writer.println("Server: " + message);
        }
    }
}
