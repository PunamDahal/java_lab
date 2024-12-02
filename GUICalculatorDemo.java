

package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class GUICalculatorDemo implements ActionListener{
    JLabel fnlbl,snlbl,resultlbl,result;
    JTextField fntxt,sntxt;
    JButton addbtn,subbtn,divbtn,mulbtn; 
    JFrame f ;    
    public GUICalculatorDemo()
    {
      f = new JFrame("Simple Calculator");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setLocationRelativeTo(null);
      f.setSize(400,400);
      
      GridLayout gr = new GridLayout(0,2,10,10);
      f.setLayout(gr);
      
      fnlbl = new JLabel("First Number".toUpperCase());
      f.add(fnlbl);
      fntxt = new JTextField();
      f.add(fntxt);
      
      
      snlbl = new JLabel("Second Number".toUpperCase());
      f.add(snlbl);
      sntxt = new JTextField();
      f.add(sntxt);
      
      
      resultlbl = new JLabel("Result".toUpperCase());      
      result = new JLabel("");
      result.setFont(new Font("ALGERIAN",Font.BOLD,20));
      result.setForeground(Color.RED);
      
      f.add(resultlbl);
      f.add(result);
      
      
      addbtn = new JButton("ADD");     
      subbtn = new JButton("SUB");
      divbtn = new JButton("DIV");
      mulbtn = new JButton("MUL");
      
      addbtn.addActionListener(this);
      subbtn.addActionListener(this);
      divbtn.addActionListener(this);
      mulbtn.addActionListener(this);
          
      f.add(addbtn);
      f.add(subbtn);
      f.add(divbtn);
      f.add(mulbtn); 
      
      
      
      f.setVisible(true);
    }
    public static void main(String[] args) {
        GUICalculatorDemo guiCalculatorDemo = new GUICalculatorDemo();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        int x = Integer.parseInt(fntxt.getText().trim());
        int y = Integer.parseInt(sntxt.getText().trim());
         float result = 0;
        
      if(ae.getActionCommand().equals("ADD"))
      {
         result = x+y; 
      }
      if(ae.getSource()==subbtn)
      {
          result = x-y;  
      }
      
      if(ae.getSource()==divbtn)
      {
         result = (float)x/y;   
      }
      
      if(ae.getSource()==mulbtn)
      {
          result = x*y; 
      }
      
      this.result.setText(Float.toString(result));
    }
}
