/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej1;

/**
 *
 * @author alumno
 */
public class Test {
    
    public static void main(String args[]){
        
        /*final Geometry[] geoms={
            new Triangle(1,2),
            new Rectangle(3,2),
            new Circle(2)
        };*/
         
        final Geometry[] geoms =new Geometry[3];
        geoms[0]=new Triangle(1,2);
        geoms[1]=new Rectangle(3,2);
        geoms[2]=new Circle(2);
        
        for (Geometry g:geoms){
            System.out.println("\n"+g.getClass().getSimpleName());
            System.out.println("Perimetro: "+g.getPerimeter()+" Area: "+g.getArea());
        }
        
    }
    
}
