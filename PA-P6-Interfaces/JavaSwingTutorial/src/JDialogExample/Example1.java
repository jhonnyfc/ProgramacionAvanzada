
package JDialogExample;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*; 

/**
 *
 * @author alumno
 */
public class Example1 {
 
    private static JDialog d;  
        
    Example1() {  
        JFrame f = new JFrame();  
        d = new JDialog(f , "Dialog Example", true);  
        d.setLayout( new FlowLayout() );  
        JButton b = new JButton ("OK");  
            
        b.addActionListener ( new ActionListener()  {  
            public void actionPerformed( ActionEvent e ){  
                Example1.d.setVisible(false); 
            }  
        });
            
        d.add( new JLabel ("Click button to continue."));  
        d.add(b);   
        d.setSize(300,300);    
        d.setVisible(true);  
        d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);           
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
    }
        
    public static void main(String args[])  {  
            new Example1();      
    }  
    
}  

