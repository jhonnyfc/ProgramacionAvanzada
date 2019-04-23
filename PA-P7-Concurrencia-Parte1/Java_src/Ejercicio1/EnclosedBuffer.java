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
        
        /* Si el buffer esta lleno (isFull = 0), se espera a que el consumidor retire un producto isFull.release.
        * Si el buffer no esta lleno (isFull > 0), el productor procedera a meter un nuevo producto */
        isFull.acquire();
        
        /* El consumidor pide permiso para poder meter un nuevo producto en el buffer */
        mutex.acquire();
        
        /* Se introduce un nuevo producto en el buffer circular */
        buffer[inBuf] = value; // actualiza el buffer 
        inBuf = (inBuf + 1) % size;
        
        /* Ya hemos metido el valor en el buffer y podemos dejar al consumidor que acceda al buffer
         * para que retire el producto */
        mutex.release();
        
        /* El consumidor notifica que se ha metido un producto en el buffer 
         * y por tanto, esta listo para poder ser retirado por el consumidor */
        isEmpty.release();
    }

    public double get() throws InterruptedException {
        double value;
        
        /* El consumidor se quedara bloqueado hasta que haya algo en el buffer (isEmpty > 0) */
        isEmpty.acquire(); // espera si el buffer está vacío 
        
        /* Peticion para poder acceder al buffer, en este caso a retirar un producto del mismo */
        mutex.acquire(); // asegura la exclusión mutua
        
        /* Se retira el producto del buffer circular */
        value = buffer[outBuf]; //lectura del buffer
        outBuf = (outBuf + 1) % size;
        
        /* Una vez retirado el producto se libera el recurso para que otros hilos puedan acceder */
        mutex.release();
        
        /* Como se ha retirado un producto del buffer, se decrementa(automaticamente) el valor del
         * semaforo isFull. De esta forma, si el productor estaba bloqueado porque el buffer estaba
         * lleno, ahora podra meter un nuevo producto en el buffer */
        isFull.release(); // notifica al productor a la espera 
        
        return value;
    }

}

/* Los semaforos al fin y al cabo no son mas que un numero. 
 * - Si ese numero es igual a cero, (Semaphore = 0):
 *      1. Semaphore.acquire: el hilo que lo ejecute se quedara bloqueado hasta que el valor del 
 *      semaforo sea mayor que cero.
 *      2. Semaphore.release: el hilo que lo ejecute hara que el valor del semaforo aumente en uno.
 *      Con esto se consigue que si otro hilo habia ejecutado el punto 1 y estaba bloqeuado, pasara 
 *      a desbloquearse y prodra continuar su ejecucion.
 * - Si el valor del semaforo es mayor que 0 (Semaphore > 0):
 *      1. Semaphore.acquire: el hilo no se quedara bloqueado y podra acceder al recurso siguiendo 
 *      su ejecucion. Ademas de que decrementara el valor del semaforo en uno (Semaphore--) automaticamente
 *      2. Semaphore.release: simplemente el valor del semaforo aumentara en uno(Semaphore++) automaticamente
 */
