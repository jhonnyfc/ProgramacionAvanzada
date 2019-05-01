/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSerializationExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Ruben
 */
public class SerializationExample {

     public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        Person p1 = new Person(19, "Ruben");
          
        FileOutputStream fileOutputStream = new FileOutputStream("yourfile.txt");
        
         try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
             objectOutputStream.writeObject(p1);
             objectOutputStream.flush();
         }

        FileInputStream fileInputStream = new FileInputStream("yourfile.txt");
        Person p2;
         try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
             p2 = (Person) objectInputStream.readObject(); 
         }

        assert p1.getAge() == p2.getAge() : "La edad coincide";
        assert p1.getName().equals(p2.getName()) : "El nombre coincide";
    
         System.out.println("- Person1" + p1);
         System.out.println("- Person2" + p2);  
    }
}