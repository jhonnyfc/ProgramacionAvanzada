package lecturaescritura;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class LeerAlumnosSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {    
        ObjectInputStream entrada=new ObjectInputStream(
                new FileInputStream("alumnos.obj"));
        
        List<Alumno> alumnos = (List<Alumno>) entrada.readObject();
        
        alumnos.forEach( System.out::println );
    }
}
