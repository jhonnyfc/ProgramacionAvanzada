/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSetExample;

/**
 *
 * @author Ruben
 */
public class MyObj {

    public String name;
    private String type;
    private int size;
    private int mark;
    
    public MyObj(String name, String type, int size, int mark) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.mark = mark;
    }  

   

    @Override
    public String toString() {
       return "- Nombre: " + name + ",\tNota: " + mark;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public int getMark() {
        return mark;
    }    
    
}
