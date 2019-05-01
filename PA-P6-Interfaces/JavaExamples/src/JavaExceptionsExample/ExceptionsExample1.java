/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaExceptionsExample;

/**
 *
 * @author alumno
 */

//The try statement allows you to define a block of code to be tested for errors while it is being executed.

//The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.

public class ExceptionsExample1 {
           
    public static void checkAge(int age) {
        if (age < 18) {
                throw new ArithmeticException("Access denied - You must be at least 18 years old.");
        } else {
            System.out.println("Access granted - You are old enough!");
        }
    }
       
    public static void main(String[ ] args) {
        
        /* Ejemplo 1 */
        try {
            int[] myNumbers = {1, 2, 3};
            System.out.println(myNumbers[10]);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
        
        /* Ejemplo 2*/
        try {
            int[] myNumbers2 = {1, 2, 3};
            System.out.println(myNumbers2[10]);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        } finally {
            System.out.println("The 'try catch' is finished.");
        }

        checkAge(15); // Set age to 15 (which is below 18...)
        
    }
}

    
