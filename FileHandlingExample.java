import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class FileHandlingExample implements ActionListener {
    JTextField textField;
    JButton saveButton;

    public FileHandlingExample() {
        JFrame frame = new JFrame("File Handling Example");
        textField = new JTextField(20);
        saveButton = new JButton("Save");

        saveButton.addActionListener(this);

        frame.add(textField, "North");
        frame.add(saveButton, "South");

        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(textField.getText());
            JOptionPane.showMessageDialog(null, "Text saved to file!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FileHandlingExample();
    }
}
