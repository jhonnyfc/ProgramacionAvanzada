/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaEnumExample;

/**
 *
 * @author alumno
 */
public class EnumExample {

    enum Level {
        LOW,
        MEDIUM,
        HIGH
    }

    public static void main(String[] args) {
        Level myVar = Level.MEDIUM;

        switch(myVar) {
          case LOW:
            System.out.println("Low level");
            break;
          case MEDIUM:
             System.out.println("Medium level");
            break;
          case HIGH:
            System.out.println("High level");
            break;
        }
    } 
}

