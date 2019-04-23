
package pa.paralelizacion;

class Tenedor {

   public char id;
   private BinarySemaphore lock = new BinarySemaphore(true);
   public void adquirir() throws InterruptedException {
      lock.P();
   }
   public void dejar() throws InterruptedException {
      lock.V();
   }
   public Tenedor(int i) {
      Integer j = new Integer(i);
      id = j.toString().charAt(0);
   }

}