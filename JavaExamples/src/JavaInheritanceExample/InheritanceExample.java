/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaInheritanceExample;

/**
 *
 * @author alumno
 */

class Vehicle {
    protected String brand = "Ford";         // Vehicle attribute
    
    public void honk() {                     // Vehicle method
        System.out.println("Tuut, tuut!");
    }
}

class Car extends Vehicle {
    private String modelName = "Mustang";   // Car attribute

    public String getModelName() {
        return modelName;
    }
    
}

public class InheritanceExample {

    public static void main(String[] args) {

        // Create a myCar object
        Car myCar = new Car();

        // Call the honk() method (from the Vehicle class) on the myCar object
        myCar.honk();

        // Display the value of the brand attribute (from the Vehicle class) and the value of the modelName from the Car class
        System.out.println(myCar.brand + " " + myCar.getModelName());
    }
} 

