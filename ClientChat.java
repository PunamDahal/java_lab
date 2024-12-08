// import java.io.*;
// import java.net.*;

// public class ClientChat {
//     public static void main(String[] args) throws IOException {
//         Socket socket = new Socket("localhost", 8000);
        
//         BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//         PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        
//         writer.println("Hello, Server! I am Punam");
//         System.out.println(reader.readLine());
//     }
// }


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientChat {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        System.out.println("Connecting to chat server...");
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            Thread listenerThread = new Thread(() -> {
                String message;
                try {
                    while ((message = in.readLine()) != null) {
                        System.out.println("Server: " + message);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });

            listenerThread.start();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter messages to send (type 'exit' to quit):");
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                out.println(input);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
