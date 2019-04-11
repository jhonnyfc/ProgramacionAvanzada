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
public class Rectangle extends Geometry {

    private float width;
    private float height;
    
    /* Constructor */
    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }  
    
    /* Metodos */
    
    public float getPerimeter(){
        return (float) width * height;
    }
    
    public float getArea(){
        return (float) width * height;
    }
}
