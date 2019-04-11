
package lecturaescritura;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class EscribirAlumnosText {

    
    public static void main(String[] args) {
        
        
       
            List<Alumno> alumnos = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                String name = "alu" + i;
                double score = Math.random() *10;
                alumnos.add(new Alumno(name, score));
            } 
         
      
        try (
           FileWriter f = new FileWriter("output.txt");      
        ){
            for (Alumno a : alumnos) {
                f.write(a.getName() + "," + a.getScore() + "\n");
            }   
           
        } catch (IOException ex) {
            Logger.getLogger(EscribirAlumnosText.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
}
