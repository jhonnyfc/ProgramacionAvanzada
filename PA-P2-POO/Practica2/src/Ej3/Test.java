/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej3;

import Ej2.Geometry;
import Ej2.Geometry3D;


/**
 *
 * @author alumno
 */
public class Test {
    
    public static void main(String[] args) {
       
        final GeometryFactory gf2=GeometryFactory.getFactory(GeometryFactory.Dimension.G2D);
        final GeometryFactory gf3=GeometryFactory.getFactory(GeometryFactory.Dimension.G3D);
        Geometry[] array =new Geometry[6];
        array[0]=gf2.createRectangle(new float[]{2,3});
        array[1]=gf2.createTriangle(new float[]{2,3});
        array[2]=gf2.createCircle(new float[]{3});
        array[3]=gf3.createRectangle(new float[]{2,3,4});
        array[4]=gf3.createTriangle(new float[]{2,3,4});
        array[5]=gf3.createCircle(new float[]{3});
        
        for (Geometry g:array){
            System.out.println("\n"+g.getClass().getSimpleName());
            System.out.println("El area: "+g.getArea());
            System.out.println("El perimetro: "+g.getPerimeter());
            if (g instanceof Geometry3D){//Geometry3D porque la esfera,... extienden fe Geometry3D
                System.out.println("El volumen: "+((Geometry3D) g).getVolumen());
            }
            
        }
    }
}
