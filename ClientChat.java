import java.io.*;
import java.net.*;

public class ClientChat {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        
        writer.println("Hello, Server!");
        System.out.println(reader.readLine());
    }
}
