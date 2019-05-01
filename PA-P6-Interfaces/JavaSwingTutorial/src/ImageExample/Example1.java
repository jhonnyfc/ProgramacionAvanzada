
package ImageExample;

import java.awt.*;  
import javax.swing.JFrame;  

public class Example1 extends Canvas{

          
    public void paint(Graphics g) {  
      
        Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage("/home/alumno/Escritorio/img.png");  
        g.drawImage(i, 0,0, this);     
    } 
    
    public static void main(String[] args) {  
        Example1 m = new Example1();  
        JFrame f = new JFrame();  
        f.add(m);  
        f.setSize(1280, 1024);  
        f.setVisible(true);  
    }    
}
