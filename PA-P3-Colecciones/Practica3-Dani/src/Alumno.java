
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Alumno {
        
    public final double nota;
    public final String nombre;

    public Alumno(String nombre, double nota) {
        this.nota = nota;
        this.nombre = nombre;
    }
    
    public static void main(String[] args) {
        
        ArrayList<Alumno> alumnos=new ArrayList<>();
        alumnos.add(new Alumno("Daniel",5));
        alumnos.add(new Alumno("Daniel",1));
        alumnos.add(new Alumno("Daniel",6));
        alumnos.add(new Alumno("Daniel",9));
        alumnos.add(new Alumno("Daniel",0));
        alumnos.add(new Alumno("Daniel",0));
        alumnos.add(new Alumno("Daniel",2));
        alumnos.add(new Alumno("Daniel",3));
        alumnos.add(new Alumno("Daniel",4));
        alumnos.add(new Alumno("Daniel",7));
        
        alumnos.sort((a,b) -> Double.compare(a.nota, b.nota));
        
        alumnos.forEach((a) -> {
            System.out.println(a.nombre+" "+a.nota);
        });
       
        int media=0;
        for (Alumno a:alumnos){
            media+=a.nota;
        }
        media/=alumnos.size();
        System.out.println("Nota media: "+media);
        
         for (Alumno a:alumnos){
            if (a.nota>media)
                System.out.println(a.nombre+" "+a.nota);
        }      
    }
}
    

