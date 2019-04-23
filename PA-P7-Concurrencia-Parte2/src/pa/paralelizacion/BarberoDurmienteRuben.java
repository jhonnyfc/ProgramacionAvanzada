
package pa.paralelizacion;

import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rabiixx on 23/04/2019
 */
public class BarberoDurmienteRuben extends Thread{
    
    Semaphore barberoListo = new Semaphore(0);          // Mutex 0, 1
    Semaphore sillasAccesibles = new Semaphore(1);      // Si es 1, el numero de sillas puede ser modficado 
    Semaphore clientesEspera = new Semaphore(0);        // Numero de clientes sentados, listos para ser atendidos
    int nSillasLibres = 5;                              // Numero de clientes 
    
    public class Barbero extends Thread{
        
        @Override
        public void run() {
        
            while(true){
                try {
                    clientesEspera.acquire();
                    sillasAccesibles.acquire();
                    nSillasLibres++;
                    barberoListo.release();
                    sillasAccesibles.release();
                    this.cortarPelo();
                } catch (InterruptedException ex) {
                    Logger.getLogger(BarberoDurmienteRuben.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        
        }
        
        public void cortarPelo(){
            
            System.out.println("[+] El barbero esta cortando el pelo ");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BarberoDurmienteRuben.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }
  
    }
    
    public class Cliente extends Thread {
        
        int id;
        String name;

        public Cliente(int id, String name) {
            this.id = id;
            this.name = name;
        }
    
        public void run(){
            while(true){
                try {
                    sillasAccesibles.acquire();
                    if (nSillasLibres > 0) {
                        System.out.println("[+] " + this.name  + "-" + this.id + " se ha sentado");
                        nSillasLibres--;
                        clientesEspera.release();
                        sillasAccesibles.release();
                        barberoListo.acquire();
                        this.cortarPelo();
                    } else {
                        System.out.println("[+] No hay sillas libres. Adios " + this.name + " - " + this.id);
                        sillasAccesibles.release();
                        break;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(BarberoDurmienteRuben.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        }
        public void cortarPelo(){
            
            System.out.println("[+] El cliente " + id + " ha comenzado ha cortarse el pelo");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BarberoDurmienteRuben.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }

    }
    
    public static void main(String[] args){
        BarberoDurmienteRuben walid = new BarberoDurmienteRuben();
        walid.start();
    }
    
    public void run(){
        
        Barbero barbero = new Barbero();
        barbero.start();
        
        int i = 0;
        String name = null;
        
        while (true) {
            name = UUID.randomUUID().toString();
            Cliente cliente = new Cliente(i, name);
            cliente.start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BarberoDurmienteRuben.class.getName()).log(Level.SEVERE, null, ex);
            }  
            ++i;
        }
    }
    
}
