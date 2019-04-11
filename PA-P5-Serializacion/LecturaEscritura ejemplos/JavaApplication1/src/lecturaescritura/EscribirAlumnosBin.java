
package lecturaescritura;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EscribirAlumnosBin {

    
    public static void main(String[] args) {
        List<Alumno> alumnos = Alumno.generar(20); 
         
      
        try (
                DataOutputStream dos = new DataOutputStream(
                    new FileOutputStream ("output"));      
                ){
            dos.writeInt( alumnos.size() );
            for (Alumno a : alumnos) {
                dos.writeInt( a.getName().length());
                dos.writeBytes(a.getName());
                dos.writeDouble( a.getScore() );
            }   
           
        } catch (IOException ex) {
            Logger.getLogger(EscribirAlumnosBin.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    
    
}
