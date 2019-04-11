/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaListExample;

/**
 *
 * @author alumno
 */
public class Gominolas {
    
    private final String nombre;
    private final int peso;
    private final int precio;

    public Gominolas(String nombre, int peso, int precio) {
        this.nombre = nombre;
        this.peso = peso;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  "Nombre: " + nombre + "\tPrecio: " + precio + "\tPeso: " + peso;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public int getPeso() {
        return peso;
    }

    public int getPrecio() {
        return precio;
    }
    
    
}
