/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author alumno
 */
public class Practica3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Alumno> arrAlumnos = new ArrayList<>();
        
        arrAlumnos.add(new Alumno("Ruben", 10));
        arrAlumnos.add(new Alumno("safsa", 5));
        arrAlumnos.add(new Alumno("Rgfdn", 7));
        arrAlumnos.add(new Alumno("gfdg", 3.4));
        arrAlumnos.add(new Alumno("ghgf", 8.9));
        arrAlumnos.add(new Alumno("fdsfn",4.7));
        arrAlumnos.add(new Alumno("iighn", 7.1));
        arrAlumnos.add(new Alumno("mbvn", 2.9));
        arrAlumnos.add(new Alumno("fhjklñ", 1.9));
        arrAlumnos.add(new Alumno("Rqewn", 5.7));
        
        Collections.sort(arrAlumnos, (a1, a2) -> new Double(a1.getNota()).compareTo(a2.getNota()));
        //arrAlumnos.sort( (a1, a2) -> a1.getNota().compareTo(a2.getNota()) );
        
        System.out.println("Lista de alumnos, ordenada por nota: \n");
        
        for (int i = 0; i < arrAlumnos.size(); i++) {
            System.out.println("\tAlumno " + i +": " + arrAlumnos.get(i).getNombre());
            System.out.println("\tNota: " + arrAlumnos.get(i).getNota() + "\n");
        }
        
        double notaMedia = 0;
        
        for (int i = 0; i < arrAlumnos.size(); i++) 
                notaMedia += arrAlumnos.get(i).getNota();
        
        notaMedia = notaMedia / arrAlumnos.size();
        
        System.out.println("- Lista de aprobados: ");
        for (int i = 0; i < arrAlumnos.size(); i++) {
            if(arrAlumnos.get(i).getNota() > notaMedia)
                System.out.println("\tNombre alumno:" + arrAlumnos.get(i).getNombre());
            
        }
       
        
        
        
    }
    
}
