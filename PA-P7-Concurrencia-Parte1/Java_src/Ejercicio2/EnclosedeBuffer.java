/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PA_P7_Ej2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author rabiixx
 */
public class EnclosedeBuffer {
    final int maxCapacity = 10;     /* Capacidad del buffer */
    double[] buffer = new double[maxCapacity];
    int inBuf = 0, outBuf = 0;
    private int size = 0;       /* Numero de elementos en el buffer */
    
    public synchronized void put(double value) throws InterruptedException {
        
        /* Este hilo se quedara bloqueado hasta que el buffer no este lleno (size < maxCapacity) */
        while(size >= maxCapacity){
            wait();
        }
        
        /* Se introduce el produto en el buffer circular */
        buffer[inBuf] = value; // actualiza el buffer 
        inBuf = (inBuf + 1) % maxCapacity;
        
        size++;

        /* Una vez introducido el producto en el buffer, se le avisa al 
         * al cosumidor de que se ha introducido un nuevo productor en el buffer,
         * y por tanto, que se despierte para retirarlo */
        notify();   /* este notify va con el wait de abajo */
    }

    public synchronized double get() throws InterruptedException {

        /* El consumidor se quedara bloqeuado hasta haya algun producto en el buffer (size > 0) */
        while(size <= 0){
            wait();
        }
        
        /* Se retira el producto del buffer circular */
        double value = buffer[outBuf]; //lectura del buffer
        outBuf = (outBuf + 1) % maxCapacity;
        size--;
        
        /* Se notifica a la cola de productores dormidos de que se ha retirado un producto del buffer,
         * y por tanto, puede despertarse para introducir un nuevo producto en el buffer */
        notify();   /* Este notify va con el wait de arriba */
        
        return value;
    }
}

/*
 * 1. wait(): el cual inserta el hilo que lo invoca en la cola de espera.
 *
 * 2. notify(): despierta a un hilo de la cola de espera.
 *
 * 3. notifyAll(): despierta a todos los hilos en la cola de espera.
 */