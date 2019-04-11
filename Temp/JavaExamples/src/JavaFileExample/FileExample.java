/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFileExample;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.util.Scanner; // Import the Scanner class to read text files

/**
 *
 * @author alumno
 */
public class FileExample {
    
    
    public static void main(String[] args) {
       
        /* Create a FILE */
        try {
            File myObj = new File("filename.txt");
            /* File myObj = new File("C:\\Users\\MyName\\filename.txt"); */
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        /* Get FILE information */
        File myObj2 = new File("filename.txt");
        if (myObj2.exists()) {
            System.out.println("File name: " + myObj2.getName());
            System.out.println("Absolute path: " + myObj2.getAbsolutePath());
            System.out.println("Writeable: " + myObj2.canWrite());
            System.out.println("Readable " + myObj2.canRead());
            System.out.println("File size in bytes " + myObj2.length());
        } else {
            System.out.println("The file does not exist.");
        }
        
        
        /* Write to a FILE */
        try {
          FileWriter myWriter = new FileWriter("filename.txt");
          myWriter.write("Files in Java might be tricky, but it is fun enough!");
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }

        /* Read a FILE */
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
          myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
  
    }
} 
    
