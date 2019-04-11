/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej3;

import Ej2.Box;
import Ej2.Geometry;
import Ej2.Sphere;
import Ej2.Tetrahedron;



/**
 *
 * @author alumno
 */
public class Geometry3DFactory extends GeometryFactory{

    @Override
    Geometry createRectangle(float[] params) {
        return new Box(params[0], params[1],params[2]);
    }

    @Override
    Geometry createTriangle(float[] params) {
        return new Tetrahedron(params[0], params[1],params[2]);
    }

    @Override
    Geometry createCircle(float[] params) {
        return new Sphere(params[0]);
    }

    
    
    
}
