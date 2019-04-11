/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author alumno
 */
public class Ej2 {
    
    public class V{
        
    }
    
    public class K{
        
    }
  
    public static void main(String[] args) {
        
        Map<String, Long> elMapa = new HashMap<>();
        
        elMapa.put("Chaitanya", 12l);
        elMapa.put("Rahul", 98543l);
        elMapa.put("Singh", 987534l);
        elMapa.put("Ajeet", 435l);
        elMapa.put("Anuj", 453533423l);
        elMapa.put("Rahul", 98543l);
        
        //for(String nombre : elMapa.keySet())
        
        //https://beginnersbook.com/2013/12/hashmap-in-java-with-example/
            
        Set set = elMapa.entrySet();
        Iterator iterator = set.iterator();
        
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }

        
        
    }
}
