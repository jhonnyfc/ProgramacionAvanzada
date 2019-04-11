/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.p7;
/**
 *
 * @author alumno
 */
public class P7 {
    
    public static void main(String[] args){
        
        final EnclosedBuffer buffer = new EnclosedBuffer();
        final Consumer consumer = new Consumer(buffer);
        final Producer producer = new Producer(buffer);
        
        producer.start();
        consumer.start();
        
        System.out.println("Finish");
        
    }

    
}
