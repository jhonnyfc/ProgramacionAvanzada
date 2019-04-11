/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PA_P7_Ej2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author alumno
 */
public class EnclosedeBuffer {
    final int maxCapacity = 10;
    double[] buffer = new double[maxCapacity];
    int inBuf = 0, outBuf = 0;
    private int size = 0;
    
    public synchronized void put(double value) throws InterruptedException {
        
        while(size >= maxCapacity){
            wait();
        }
        
        buffer[inBuf] = value; // actualiza el buffer 
        inBuf = (inBuf + 1) % maxCapacity;
        size++;
        
        notify();   /* este notify va con el wait de abajo */
    }

    public synchronized double get() throws InterruptedException {

        while(size <= 0){
            wait();
        }
        
        double value = buffer[outBuf]; //lectura del buffer
        outBuf = (outBuf + 1) % maxCapacity;
        size--;
        
        notify();   /* Este notify va con el wait de arriba */
        
        return value;
    }
}
