/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.paralelizacion;

class Filosofo extends Thread {

   private char estado = 'p';
   private Tenedor L, R;
   public Filosofo(Tenedor left, Tenedor right) {
      super();
      L = left;
      R = right;
   }

   protected void piensa() throws InterruptedException {
      sleep((long)(Math.random()*500));
   }

   protected void come() throws InterruptedException {
      sleep((long)(Math.random()*700));
   }

   public char estado() {
      return estado;
   }

   public void run() {
      int i;
      try {
         for (i = 0; i < 10; i++) {
            estado = 'p';
            piensa();
            estado = L.id;
            sleep(1);
            L.adquirir();
            estado = R.id;
            sleep(1);
            R.adquirir();
            estado = 'c';
            come();
            L.dejar();
            R.dejar();
        }
        estado = 'd';
      }
      catch (InterruptedException e) {
        return;
      }
   }

}