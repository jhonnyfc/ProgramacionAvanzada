
package ButtonExample;

import javax.swing.*; 

/**
 * Example of displaying image on the button:
 * @author alumno
 */
public class Example4 {
   
    public Example4(){    
        
        JFrame f=new JFrame("Button Example");            
            
        JButton b=new JButton(new ImageIcon("/home/alumno/Escritorio/button2.jpeg"));    
        b.setBounds(356, 356, 256, 256);   
            
        f.add(b);    
        f.setSize(1000,1000);    
        f.setLayout(null);    
        f.setVisible(true);    
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }         
        
    public static void main(String[] args) {    
        new Example4();    
    }    
} 
