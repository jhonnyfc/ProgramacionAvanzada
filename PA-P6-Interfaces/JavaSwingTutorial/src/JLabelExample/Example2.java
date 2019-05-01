package JLabelExample;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  

/**
 * Java JLabel Example with ActionListener
 * @author alumno
 */

/**
 * ActionListener es una interface que extiende de EventListener
 * y que invoca el metodo public void actionPerformed(ActionEvent e); 
 */
public class Example2 extends JFrame implements ActionListener{

        JTextField tf; JLabel l; JButton b;  
        
        public Example2(){  
            tf = new JTextField();  
            tf.setBounds(50,50, 150,20);  
            
            l = new JLabel();  
            l.setBounds(50,100, 250,20);      
            
            b = new JButton("Find IP");  
            b.setBounds(50,150,95,30);  
            b.addActionListener(this);    
            
            add(b);add(tf);add(l);    
            setSize(400,400);  
            setLayout(null);  
            setVisible(true);  
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        }  
        
        public void actionPerformed(ActionEvent e) {  
            try{  
                String host = tf.getText();  
                String ip = java.net.InetAddress.getByName(host).getHostAddress();  
                l.setText("IP of " + host + " is: " + ip);  
            }catch(Exception ex){System.out.println(ex);}  
        }  
        
        public static void main(String[] args) {  
            new Example2();  
        } 
}  

