/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej3;

import Ej2.Circle;
import Ej2.Geometry;
import Ej2.Rectangle;
import Ej2.Triangle;

/**
 *
 * @author alumno
 */
public class Geometry2DFactory extends GeometryFactory{

    @Override
    Geometry createRectangle(float[] params) {
        
        return new Rectangle(params[0], params[1]);
    }

    @Override
    Geometry createTriangle(float[] params) {
        
        return new Triangle(params[0], params[1]);
    }

    @Override
    Geometry createCircle(float[] params) {
        
        return new Circle(params[0]);
    }
}
