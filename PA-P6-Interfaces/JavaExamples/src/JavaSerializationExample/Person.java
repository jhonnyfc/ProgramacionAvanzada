/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSerializationExample;

import java.io.Serializable;

/**
 *
 * @author alumno
 */
class Person implements Serializable {

    
    private final  String country = "ITALY";
    private final int age;
    private final String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" + "country=" + country + ", age=" + age + ", name=" + name + '}';
    }
 
    
    
}

