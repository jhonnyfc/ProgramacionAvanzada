/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej3;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author alumno
 */
public class Ej3 {
    
    public static void main(String[] args) {
        String s="[1, 2, 3]+[4, 5, 7]";
        
        s=s.replaceAll("\\[", " ")
                .replaceAll("\\]"," ")
                .replaceAll(","," ");
        
        final int plusindex=s.indexOf("+");
        
        if(plusindex==-1){
            //error
        }
        Set<Integer> setA=new TreeSet<>();
        Set<Integer> setB=new TreeSet<>();
        
        String p1=s.substring(0,plusindex-1);
        String p2=s.substring(plusindex+1,s.length());
        
        parseInts(p1,setA);
        parseInts(p2,setB);
        
    }

    private static void parseInts(String str, Set<Integer> set) {
        String[] parts=str.split(" ");
        for (String part:parts){
            if (!part.isEmpty()){
                set.add(Integer.parseInt(part));
            }
        }
        
    }
}
