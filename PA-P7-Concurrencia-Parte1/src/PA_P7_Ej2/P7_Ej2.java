/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PA_P7_Ej2;

import pa.p7.EnclosedBuffer;

/**
 *
 * @author alumno
 */
public class P7_Ej2 {
        
    public static void main(String[] args){
        
        final EnclosedBuffer buffer = new EnclosedBuffer();
        final pa.p7.Consumer consumer = new pa.p7.Consumer(buffer);
        final pa.p7.Producer producer = new pa.p7.Producer(buffer);
        
        producer.start();
        consumer.start();
        
        System.out.println("Finish");   
    }
 
}
