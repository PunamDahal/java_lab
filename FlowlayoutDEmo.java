

package swing;

import java.awt.FlowLayout;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;



public class FlowlayoutDEmo {

     JFrame f ; 
     
     
     JButton btn[] = new JButton[20];
    public FlowlayoutDEmo() {
      f = new JFrame("FlowLayout Example");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setLocationRelativeTo(null);
      f.setSize(400,400);
      
        for (int i = 0; i < btn.length; i++) {
           btn[i] = new JButton(Integer.toString(i+1));
           f.add(btn[i]);           
        }
      f.setLayout(new FlowLayout(FlowLayout.LEFT ,20,20));
      f.setVisible(true);
    }
    
    public static void main(String[] args) {
        new FlowlayoutDEmo();
    }
    
}
