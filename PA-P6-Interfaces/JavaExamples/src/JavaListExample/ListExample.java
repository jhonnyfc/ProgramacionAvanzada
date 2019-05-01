/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaListExample;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alumno
 */
public class ListExample {
    
    
    
    public static void main(String[] args) {

        
        Map<String, Gominolas> elMapa = new HashMap<>();
            
        Gominolas g = new Gominolas("ChupaChups", 34, 13);
        elMapa.put(g.getNombre(), g);
        
        System.out.println(elMapa.size());
        
        // Print keys
        System.out.println("[+] Claves: ");
        for (String i : elMapa.keySet()) {
            System.out.println("\t" + i);
        }
        
        elMapa.keySet().forEach((i) -> {
            System.out.println("\t" + i);
        });
         
        // Print values
        System.out.println("[+] Valores: ");
        for (Gominolas i : elMapa.values()) {
            System.out.println("\t" + i);
        }
        
        elMapa.values().forEach((i) -> {
            System.out.println("\t" + i);
        });
        
        // Print keys and values
        System.out.println("[+] Keys and values: ");
        for (String i : elMapa.keySet()) {
            System.out.println("\tKey: " + i + ",\tValue: " + elMapa.get(i));
        }
        
    }


}
