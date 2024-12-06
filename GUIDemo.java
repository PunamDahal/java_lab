import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIDemo implements ActionListener {
    JLabel usernamelbl, passwordlbl;
    JTextField usernametxt;
    JPasswordField passwordtxt;
    JButton loginbtn, cancelbtn;

    JFrame frame;

    public GUIDemo() {
        frame = new JFrame();
        frame.setTitle("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null);

        // Label for Username
        usernamelbl = new JLabel("User Name:");
        usernamelbl.setBounds(10, 10, 100, 25);
        frame.add(usernamelbl);

        // Label for Password
        passwordlbl = new JLabel("Password :");
        passwordlbl.setBounds(10, 40, 100, 25);
        frame.add(passwordlbl);

        // Text field for Username
        usernametxt = new JTextField();
        usernametxt.setBounds(115, 10, 200, 25);
        frame.add(usernametxt);

        // Password field
        passwordtxt = new JPasswordField();
        passwordtxt.setBounds(115, 40, 200, 25);
        frame.add(passwordtxt);

        // Login button
        loginbtn = new JButton("Login");
        loginbtn.setBounds(10, 70, 80, 25);
        loginbtn.addActionListener(this);
        frame.add(loginbtn);

        // Cancel button
        cancelbtn = new JButton("Cancel");
        cancelbtn.setBounds(95, 70, 80, 25);
        cancelbtn.addActionListener(this);
        frame.add(cancelbtn);

        frame.setVisible(true);
    }

    // Main method to run the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUIDemo());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginbtn) {
            // For demonstration, the valid username is "admin" and password is "password123"
            String username = usernametxt.getText();
            char[] password = passwordtxt.getPassword();
            String passwordText = new String(password);

            if (username.equals("admin") && passwordText.equals("password123")) {
                JOptionPane.showMessageDialog(frame, "Login successful! Welcome " + username);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getSource() == cancelbtn) {
            if (JOptionPane.showConfirmDialog(frame, "Do you want to cancel?", "Exit", JOptionPane.YES_NO_OPTION) == 0) {
                frame.dispose(); 
            }
        } 
    }
}
