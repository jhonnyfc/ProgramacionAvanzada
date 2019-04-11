/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej2;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author alumno
 */
public interface Ej2{
    
    public static void main(String[] args){
        
        Map<String,Long> map = new HashMap<>();//Hecho asi no hacen falta las dos clases(V,K)
        
        map.put("Dani1",(long) 523456789);
        map.put("Dani2",(long) 153486799);
        map.put("Dani3",(long) 623456789);
        map.put("Dani4",(long) 613456789);
        map.put("Dani5",(long) 121899999);
        map.put("Dani5",(long) 121865678);
        //no puede haber repetidos
        //se queda con el ultimo introducido
    
        for (String nombre:map.keySet()){//no sale siguiendo ningún orden
            System.out.println(nombre+"->"+map.get(nombre));
        }
        System.out.println("\n");
        for (Long nombre:map.values()){
            System.out.println(""+nombre);
        }
        
    }
            
    
}
