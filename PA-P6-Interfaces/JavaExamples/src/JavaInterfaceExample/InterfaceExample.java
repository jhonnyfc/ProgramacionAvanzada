/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaInterfaceExample;

/**
 *
 * @author alumno
 */

    // interface
    interface Animal {
        public void animalSound(); // interface method (does not have a body)
        public void sleep(); // interface method (does not have a body)
    }

    // Pig "implements" the Animal interface
    class Pig implements Animal {

        @Override
        public void animalSound() {
            // The body of animalSound() is provided here
            System.out.println("The pig says: wee wee");
        }

        @Override
        public void sleep() {
            // The body of sleep() is provided here
            System.out.println("Zzz");
        }
    }

    public class InterfaceExample {
        public static void main(String[] args) {
            Pig myPig = new Pig();  // Create a Pig object
            myPig.animalSound();
            myPig.sleep();
        }
    }

