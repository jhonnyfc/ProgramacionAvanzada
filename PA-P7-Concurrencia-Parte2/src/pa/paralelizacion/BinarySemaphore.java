/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.paralelizacion;

public class BinarySemaphore {

   protected boolean value;
   public BinarySemaphore (boolean value) {
      this.value = value;
   }

   public synchronized void P() throws InterruptedException {
      while (!value) wait();
      value = false;
      }

   public synchronized void V() {
      value = true;
      notify();
   }

}