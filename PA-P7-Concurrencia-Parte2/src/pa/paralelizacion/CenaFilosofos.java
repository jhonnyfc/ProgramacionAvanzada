
package pa.paralelizacion;

class CenaFilosofos {

    static Tenedor [] tenedor = new Tenedor[5];
    static Filosofo[] cena = new Filosofo [5];

    public static void main(String[] args) {
        int i, j = 0;
         boolean goOn;
        for (i = 0; i < 5; i++) {
            tenedor[i] = new Tenedor(i);
      }
      for (i=0; i < 5; i++) {
         cena[i] = new Filosofo(tenedor[i],tenedor[(i+1)%5]);
      }
      for (i = 0; i < 5; i++) {
         cena[i].start();
      }
      int newPrio = Thread.currentThread().getPriority()+1;
      Thread.currentThread().setPriority(newPrio);
      goOn = true;
      while (goOn) {
         for (i = 0; i < 5; i++) {
            System.out.print(cena[i].estado());
         }
         if (++j % 5 == 0) System.out.println();
         else System.out.print(' ');
         goOn = false;
         for (i = 0; i < 5; i++) {
            goOn |= cena[i].estado() != 'd';
         }
         try {
            Thread.sleep(51);
         }
         catch (InterruptedException e) {
            return;
         }
     } 
  }

}
