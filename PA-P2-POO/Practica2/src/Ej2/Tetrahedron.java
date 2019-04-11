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
public class Tetrahedron extends Triangle implements Geometry3D{

    public Tetrahedron(float base, float height,float depth) {
        super(base, height);
    }
    
    @Override
    public float getVolumen() {
        return (float) (super.getArea()*super.getArea()*Math.sqrt(3)/12);
    }
    

    @Override
    public float getPerimeter() {
        return 6*super.getBase();
    }
    
    
    @Override
    public float getArea() {
       return (float) (super.getArea()*super.getArea()*Math.sqrt(3));
    }


    
}
