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
public class Triangle implements Geometry{
    private final float base;
    private final float height;

    public Triangle(float base, float height) {
        this.base = base;
        this.height = height;
    }
    
    public float getPerimeter() {
        return base*3;//triangulo equilatero
    }
    
    public float getArea(){
        return (base*height)/2;
    }

    public float getBase() {
        return base;
    }

    public float getHeight() {
        return height;
    }
    
    
}
