import java.io.*;
import java.net.*;

public class ServerArea {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket clientSocket = serverSocket.accept();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        
        String length = reader.readLine();
        String breadth = reader.readLine();
        
        double area = Double.parseDouble(length) * Double.parseDouble(breadth);
        writer.println("Area: " + area);
    }
}
