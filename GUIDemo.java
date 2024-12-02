

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GUIDemo implements ActionListener
{


JLabel usernamelbl ,passwordlbl;
JTextField usernametxt;
JPasswordField passwordtxt;
JButton loginbtn, cancelbtn ,resetbtn ;

JFrame frame;
    public GUIDemo()
    {
        frame = new JFrame();
        frame.setTitle("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null);

// Label
        usernamelbl   = new JLabel("User Name:");
        usernamelbl.setBounds(10,10,100,25);
        frame.add(usernamelbl);

        passwordlbl   = new JLabel("Password :");
        passwordlbl.setBounds(10,40,100,25);
        frame.add(passwordlbl);

//Text field

    usernametxt = new JTextField();
    usernametxt.setBounds(115,10,200,25);
    frame.add(usernametxt);

    passwordtxt = new JPasswordField();
    passwordtxt.setBounds(115,40,200,25);
    frame.add(passwordtxt);


//Button  


   loginbtn = new JButton("Login");    
   loginbtn.setBounds(10,70,80,25); 
   loginbtn.addActionListener(this);
   frame.add(loginbtn);

   cancelbtn = new JButton("Cancel");    
   cancelbtn.setBounds(95,70,80,25); 
   cancelbtn.addActionListener(this);
   frame.add(cancelbtn);

   resetbtn = new JButton("Reset");    
   resetbtn.setBounds(180,70,80,25); 
   resetbtn.addActionListener(this);
   frame.add(resetbtn);


  frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        new GUIDemo();
    }


 @Override
 public void actionPerformed(ActionEvent ae)
 {
    if(ae.getSource()==loginbtn)
    {
      JOptionPane.showMessageDialog(null,"Login successful !!!" + usernametxt.getText());
    }
    else if(ae.getSource()==cancelbtn)
    {
       // System.out.println(JOptionPane.showConfirmDialog(null,"Do You want to cancel ?"));
        if(JOptionPane.showConfirmDialog(null,"Do You want to cancel ?")==0)
        {
           frame.hide();
        }
    }
    else if(ae.getSource()==resetbtn)
    {
        usernametxt.setText("");
        passwordtxt.setText("");

    }
 }

}