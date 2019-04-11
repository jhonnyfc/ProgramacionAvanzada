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
public class Sphere extends Circle implements Geometry3D {

    public Sphere(float radius) {
        super(radius);
    }
    
    @Override
    public float getVolumen() {
        return (float) ((4/3)*Math.PI*super.getRadius()*super.getRadius()*super.getRadius());
    }

    @Override
    public float getArea() {
        return (float) (4*Math.PI*super.getRadius()*super.getRadius());
    }
    
    public float getPerimeter() {
        return Float.POSITIVE_INFINITY;
    }
    
   
}
