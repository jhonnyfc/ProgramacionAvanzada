/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.p5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Country {
    
    private final String country;
    private final String Region;
    private final int Population;
    private final int area;
    private final int GDP;


    public Country(String country, String Region, int Population, int area, int GDP) {
        this.country = country;
        this.Region = Region;
        this.Population = Population;
        this.area = area;
        this.GDP = GDP;
    }

    
    public static void main(String[] args) {
        List<Country> countries = new ArrayList<>();
        countries = parseCSV("/home/alumno/Escritorio/countries.csv");           
        
        /* Ejercicio 1*/
        System.out.println("Contenido del fichero: \n");
        countries.forEach(System.out::println);
        
        
        /* Ejercicio 2 */
        long pmedia = 0;
        
        for (Country c : countries) {
            pmedia += (c.getPopulation()/223);
        }
        System.out.println("Paises con populacion por encima de la media: " + pmedia);
        for (Country c : countries) {
            if(c.getPopulation() > pmedia)
                System.out.println("\t- Pais: " + c.getCountry());
        }
        
        /* Ejercicio 3 */
        List<Region> regiones = new LinkedList<>();
        regiones.add(new Region("ASIA (EX. NEAR EAST)", 0) );
        regiones.add(new Region("EASTERN EUROPE", 0) );
        regiones.add(new Region("NORTHERN AFRICA", 0) );
        regiones.add(new Region("OCEANIA", 0) );
        regiones.add(new Region("WESTERN EUROPE ", 0) );
        regiones.add(new Region("SUB-SAHARAN AFRICA ", 0) );
        regiones.add(new Region("LATIN AMER. & CARIB", 0) );
      
            
        }
                      
    
    public static class Region{
        
        private String name;
        private int numConuntries;

        public Region(String name, int numConuntries) {
            this.name = name;
            this.numConuntries = numConuntries;
        }

        public String getName() {
            return name;
        }

        public int getNumConuntries() {
            return numConuntries;
        }
               
    }

     /*
    * Lee el fichero .csv línea a línea en modo texto. Si la línea contiene el número 
    * adecuado de "," , hace un split y parsea cada campo para crear el Country.
    */       
    //public List<Country> parseCSV(String file path){
    public static List<Country> parseCSV(String filepath){
       
        List<Country> countries = new ArrayList<>();
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            for (String line; (line = br.readLine()) != null;) {
                if(i > 5 && i < 228){
                    String[] parts = line.split(",");
                    if(parts.length > 20){
                        parts[0] = parts[0].concat(parts[1]);
                        Country c = new Country(
                            parts[0], 
                            parts[2], 
                            Integer.parseInt(parts[3]),
                            Integer.parseInt(parts[4]),
                            Integer.parseInt(parts[9]));                        
                        countries.add(c);
                    }else{
                        Country c = new Country(
                            parts[0], 
                            parts[1],
                            Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]),
                            Integer.parseInt(parts[8]));  
                        countries.add(c);
                    }
                }
                i++;                                   
            }
        } catch (IOException ex) {
            Logger.getLogger(Country.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return countries;
    }
    
    @Override
    public String toString() {
        return '{' + "Pais = " + country + ", Region = " + Region + ", Populacion = " + Population 
                + ", Area =" + area + ", GDP = " + GDP +'}';
    }
    
    public String getCountry() {
        return country;
    }
    
    public long getPopulation() {
        return Population;
    }
      
}
