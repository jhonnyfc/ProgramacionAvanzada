/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ej3;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class GeometryFactory {  /* Singleton */
    
    /* Variable estatica single_instance de tipo GeometryFactory */
    private static GeometryFactory single_instance = null;
    
    
   
    /*
    private static GeometryFactory getFactory(Dimension d){
        return d;
    }*/
    
    /* Contructor privado */
    private GeometryFactory(){};
    
    /* Clase estatica para instanciar la clase GeometryFactory */ 
    public static GeometryFactory getFactory(){
        if(single_instance == null){
            single_instance = new GeometryFactory();
        }
        return single_instance;
    }
    
    public enum Dimension {d2, d3};

    public Dimen() {   
        
        Dimension d1, d2;
        d1 = Dimension.d2;
        d2 = Dimension.d3;
        
        System.out.println("Introduce la dimension(3D = d2/ 2D = d3");
        Scanner sc = new Scanner(System.);
        int d = sc.next();
        if(d == d1)/* (d) equals (d1)*/
            Geometry2DFactory g2 = new ;
            
              
}  
    
    /* Metodos */
    public Geometry createRectangle(float[] params ){
    }
    public Geometry createTriangle(float[] params ){
    }
    public Geometry createCircle(float[] params ){
    }
    
}
