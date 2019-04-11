/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.p7;

import java.util.concurrent.Semaphore;
/**
 *
 * @author alumno
 */

public class EnclosedBuffer {
    final int size = 10;
    double[] buffer = new double[size];
    int inBuf = 0, outBuf = 0;
    Semaphore mutex = new Semaphore(1);
    Semaphore isEmpty = new Semaphore(0);
    Semaphore isFull = new Semaphore(size);

    public void put(double value) throws InterruptedException {
        isFull.acquire(); // esperar si el buffer está lleno
        mutex.acquire(); // asegura la exclusión mutua
        buffer[inBuf] = value; // actualiza el buffer 
        inBuf = (inBuf + 1) % size;
        mutex.release();
        isEmpty.release(); // notifica al consumidor a la espera
    }

    public double get() throws InterruptedException {
        double value;
        isEmpty.acquire(); // espera si el buffer está vacío 
        mutex.acquire(); // asegura la exclusión mutua
        value = buffer[outBuf]; //lectura del buffer
        outBuf = (outBuf + 1) % size;
        mutex.release();
        isFull.release(); // notifica al productor a la espera 
        return value;
    }

}
