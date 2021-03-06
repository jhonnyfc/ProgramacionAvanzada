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
public class Rectangle implements Geometry {
    
    private final float width;
    private final float height;

    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }
    
    public float getPerimeter() {
        return 2*width+2*height;
    }
    
    public float getArea(){
        return width*height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
    
    
    
}
