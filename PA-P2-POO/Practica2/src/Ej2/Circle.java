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
public class Circle implements Geometry {
    private final float radius;

    public Circle(float radius) {
        this.radius = radius;
    }
    
    public float getPerimeter() {
        return (float) (2*Math.PI*radius);
    }
    
    public float getArea(){
        return (float)(Math.PI*radius*radius);
    }

    public float getRadius() {
        return radius;
    }
    
    
}
