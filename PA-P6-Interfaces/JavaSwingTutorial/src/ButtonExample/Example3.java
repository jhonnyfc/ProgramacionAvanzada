package ButtonExample;

import java.awt.event.*;  
import javax.swing.*;  

/**
 * Java JButton Example with ActionListener
 * @author alumno
 */
public class Example3 {
 
    public static void main(String[] args) {  
        
        JFrame f = new JFrame("Button Example");  
        
        final JTextField tf = new JTextField();  
        tf.setBounds(50,50, 150,20);  
        
        JButton b = new JButton("Click Here");  
        b.setBounds(50,100,640,320);  
        b.setEnabled(true);                 /*It is used to enable or disable the button. */
        b.setText("Boton");                 /* It is used to set specified text on button */
        System.out.println(b.getText());    /* It is used to return the text of the button. */

        
        
        b.addActionListener(new ActionListener(){  /* Listener of button */
    
            public void actionPerformed(ActionEvent e){  
                tf.setText("Welcome to Javatpoint.");  
            }  
        });  
        
        f.add(b);f.add(tf);  
        f.setSize(700,700);  
        f.setLayout(null);  
        f.setVisible(true);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    

    }  
}
