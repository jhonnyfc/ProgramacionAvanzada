/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ej3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class Test {
    
    public static void main(String args[]){
    
        ArrayList <Geometry> geoms = new ArrayList<>();
        
        geoms.add(new Rectangle(0,0));
        geoms.add(new Circle(0));
        geoms.add(new Triangle(0,0));
        
        for (Geometry g : geoms) {
            System.out.println("- Perimetro: " + g.getPerimeter());
            System.out.println("- Area: " + g.getArea());
        }
    }
}
