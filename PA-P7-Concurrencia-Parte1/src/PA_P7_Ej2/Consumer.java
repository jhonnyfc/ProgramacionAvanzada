/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PA_P7_Ej2;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import pa.p7.EnclosedBuffer;

/**
 *
 * @author alumno
 */
public class Consumer extends Thread{
    
    private EnclosedBuffer buffer;

    public Consumer(EnclosedBuffer buffer) {
        super("consumer");
        this.buffer = buffer;
    }
    
    @Override
    public void run( ){
        try{        
            for (int i = 0; i < 30; i++) {
                final double d = buffer.get();
                System.out.println("Consumidor lee del buffer"); 
                sleep(50);
            }
        } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

