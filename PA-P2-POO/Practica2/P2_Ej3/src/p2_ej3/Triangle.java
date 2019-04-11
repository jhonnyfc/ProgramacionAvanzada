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
public class Triangle extends Geometry {
    
    private float base;
    private float height;

    public Triangle(float base, float height) {
        this.base = base;
        this.height = height;
    }
    
    public float getPerimeter(){
        return (float) base* height;
    }
    
    public float getArea(){
        return (float) base* height;
    }
  
}
