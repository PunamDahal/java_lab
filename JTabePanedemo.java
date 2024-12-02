
package swing;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;


public class JTabePanedemo {

    JTabbedPane jtp;
    public JTabePanedemo() {
        JFrame f = new JFrame();
        f.setTitle("Example of Jtabbed Pane");
        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //JTabbedPane 
        
        jtp = new JTabbedPane();
        jtp.setBounds(50, 50, 410, 300);
        jtp.addTab("Hobbies" ,new HobbiesTab());
         jtp.addTab("Education" ,new EducationTab());
          jtp.addTab("Gander" ,null);
        f.add(jtp);
        
        f.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        JTabePanedemo jTabePanedemo = new JTabePanedemo();
    }
}


class HobbiesTab extends JPanel
{
    JCheckBox ch1,ch2,ch3,ch4;
    JTextArea commenttarea;
    JLabel commentlbl;
    public HobbiesTab() {
       
        setLayout(null); 
        ch1 = new JCheckBox("Gaming");
        ch2 = new JCheckBox("Swimming");
        ch3 = new JCheckBox("Riding");
        ch4 = new JCheckBox("Writting");
        
        add(ch1);        
        add(ch2);         
        add(ch3);        
        add(ch4);
       //setBackground(Color.BLACK);
         
        ch1.setBounds(100, 50, 75, 30);
        ch2.setBounds(100, 85, 75, 30);
        ch3.setBounds(100, 120, 75, 30);
        ch4.setBounds(100, 155, 75, 30);
        
        commentlbl   = new JLabel("Comment :");
        commentlbl.setBounds(100, 190, 80, 30);
        add(commentlbl);
       //text area
       
       
       commenttarea = new JTextArea();
       JScrollPane pane= new JScrollPane();
       pane.add(commenttarea);
       
       commenttarea.setBounds(190, 190, 200, 60);
        add(commenttarea);
       
       
        setVisible(true);
    }
    
}

class EducationTab extends JPanel
{
    JComboBox jcb;
    public EducationTab() {
        
        String []str = {"A" ,"B","c"};
      jcb = new JComboBox(str);
      jcb.addItem("PHD");
      jcb.addItem("Master");
      jcb.addItem("Bachelor");
      jcb.addItem("High School");
      jcb.addItem("Secondary");
      jcb.addItem("Primary");
      setBackground(Color.MAGENTA);
      add(jcb);      
      
    }
    
}