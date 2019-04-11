/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescritura;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno
 */
public class Alumno implements Serializable{
    String name;
    double score;

    public Alumno() {
    }

    public Alumno(String name, double score) {
        this.name = name;
        this.score = score;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Alumno{" + "name=" + name + ", score=" + score + '}';
    }
    
    public static List<Alumno> generar(int nAlumnos) {
        List<Alumno> alumnos = new ArrayList<>();
        for (int i = 0; i < nAlumnos; i++) {
            String name = "alu" + i;
            double score = Math.random() *10;
            alumnos.add(new Alumno(name, score));
        }
        return alumnos;
    }
}
