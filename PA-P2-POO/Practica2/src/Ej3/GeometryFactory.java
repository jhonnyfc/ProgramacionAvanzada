/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej3;

import Ej2.Geometry;

/**
 *
 * @author alumno
 */
public abstract class GeometryFactory {
    
    public enum Dimension{
        G2D, G3D;
    }
    
    final static GeometryFactory g2d=new Geometry2DFactory();
    final static GeometryFactory g3d=new Geometry3DFactory();
    
    protected GeometryFactory(){}

    static GeometryFactory getFactory (Dimension dimension){
        if (dimension==Dimension.G2D){
            return g2d;
        }
        else if (dimension==Dimension.G3D){
            return g3d;
        }
        return null;
    }
    
    abstract Geometry createRectangle(float[] params);
    
    abstract Geometry createTriangle(float[] params);
    
    abstract Geometry createCircle(float[] params);
    
}
