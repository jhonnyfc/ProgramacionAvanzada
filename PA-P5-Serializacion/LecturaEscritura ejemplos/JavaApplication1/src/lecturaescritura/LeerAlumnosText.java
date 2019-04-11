package lecturaescritura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class LeerAlumnosText {
    public static void main(String[] args) {
         List<Alumno> alumnos = new ArrayList<>();
            
        try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
            for (String line; (line = br.readLine()) != null;) {
                String[] parts = line.split(",");
                Alumno a = new Alumno(
                        parts[0], 
                        Double.parseDouble( parts[1] ) );
                alumnos.add(a);
            }
        } catch (IOException ex) {
            Logger.getLogger(LeerAlumnosText.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        alumnos.forEach( System.out::println );
    }
}
