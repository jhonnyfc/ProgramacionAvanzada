
package lecturaescritura;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LeerAlumnosBin {

    
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();
         
        try (
                DataInputStream dis = new DataInputStream(
                    new FileInputStream ("output"));      
                ){
            
             int nAlumnos = dis.readInt();
             for (int i = 0; i < nAlumnos; i++) {
                int lenCadena = dis.readInt();
                byte[] bytes = new byte[lenCadena];
                dis.read(bytes);
                String name = new String(bytes);
                double score = dis.readDouble();
                Alumno a = new Alumno(name, score);
                alumnos.add(a);
            }
           
        } catch (IOException ex) {
            Logger.getLogger(LeerAlumnosBin.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        alumnos.forEach( System.out::println );
    }

    
    
}
