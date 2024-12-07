import java.io.*;
import java.net.*;

public class ClientArea {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        
        writer.println("5");
        writer.println("10");
        
        System.out.println(reader.readLine());
    }
}
