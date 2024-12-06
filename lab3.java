
import java.io.FileWriter;
import java.io.IOException;

public class lab3{
    public static void main(String[] args) {
        String fileName = "abc.txt"; 
        String content = "Hello, World!"; 

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("Content written to " + fileName + " successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
