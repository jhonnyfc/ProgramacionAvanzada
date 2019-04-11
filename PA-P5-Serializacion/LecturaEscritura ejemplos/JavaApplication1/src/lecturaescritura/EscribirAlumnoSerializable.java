/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescritura;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class EscribirAlumnoSerializable {
    
        
    public static void main(String[] args) throws IOException {
        List<Alumno> alumnos = Alumno.generar(20); 
        
        ObjectOutputStream salida =
                new ObjectOutputStream(
                        new FileOutputStream("alumnos.obj"));
      
      salida.writeObject( alumnos );
      
      salida.close();
    }
}
