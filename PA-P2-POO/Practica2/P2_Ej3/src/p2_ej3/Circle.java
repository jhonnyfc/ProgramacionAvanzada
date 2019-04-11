/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ej3;

/**
 *
 * @author alumno
 */
public class Circle extends Geometry {
    
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }
    
    public float getPerimeter(){
        return (float) (2 * 3.1416 * radius);
    }
    
    public float getArea(){
        return (float) (3.1416 * radius * radius);
    }
    
}
