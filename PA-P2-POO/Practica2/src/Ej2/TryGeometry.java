/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej2;

/**
 *
 * @author alumno
 */
public class TryGeometry {
    
    public static void main(String[] args) {
        
        final Geometry[] geoms =new Geometry[6];
        geoms[0]=new Triangle(1,2);
        geoms[1]=new Rectangle(3,2);
        geoms[2]=new Circle(3);
        geoms[3]=new Box(1,5,2);
        geoms[4]=new Sphere(3);
        geoms[5]=new Tetrahedron(1,3,2);
        
        for (Geometry g:geoms){
            System.out.println("\n"+g.getClass().getSimpleName());
            if (g instanceof Geometry3D){
                System.out.println("El volumen: "+((Geometry3D) g).getVolumen());
            }
            System.out.println("El area; "+g.getArea());
            System.out.println("El perimetro: "+g.getPerimeter());
         }
    }
}
