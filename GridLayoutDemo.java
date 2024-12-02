

package swing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class GridLayoutDemo {
    JFrame f ; 
     
     
     JButton btn[] = new JButton[20];
    public GridLayoutDemo() {
      f = new JFrame("FlowLayout Example");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setLocation(100,100);
      f.setSize(400,400);
      
        for (int i = 0; i < btn.length; i++) {
           btn[i] = new JButton(Integer.toString(i+1));
           f.add(btn[i]); 
           btn[i].addActionListener(new ActionEventHandeler(i));
           btn[i].addMouseListener(new MouseEventhandeler());
        }
      f.setLayout(new GridLayout(0,4,5,5));
      f.setVisible(true);
    }
    
    public static void main(String[] args) {
        new GridLayoutDemo();
    }
    
}


class ActionEventHandeler implements ActionListener
{
 int i;
 public ActionEventHandeler(int i )
 {
    this.i = i; 
 }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        JOptionPane.showMessageDialog(null, "Clicked ".toUpperCase() +(i+1));
    }
    
}

class MouseEventhandeler implements MouseListener
{
@Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
       
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       
    }
    

    @Override
    public void mouseEntered(MouseEvent me) {
         System.out.println("Mouse Entered".toUpperCase());
    }

    @Override
    public void mouseExited(MouseEvent me) {
      System.out.println("Mouse Exited".toUpperCase());
    }
    
}
