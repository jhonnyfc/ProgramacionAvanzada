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
public class Box extends Rectangle implements Geometry3D{
    
    private final float depth;

    public Box(float depth, float width, float height) {
        super(width, height);
        this.depth = depth;
    }
    
    @Override
    public float getVolumen() {
        return super.getWidth()*super.getHeight()*depth;
    }

    @Override
    public float getPerimeter() {
        return 4*(super.getWidth()+super.getHeight())+4*depth;
    }

    @Override
    public float getArea() {
       return 2*super.getWidth()*super.getHeight()+2*super.getWidth()*depth+2*super.getHeight()*depth;
    }

    

    
    
}
