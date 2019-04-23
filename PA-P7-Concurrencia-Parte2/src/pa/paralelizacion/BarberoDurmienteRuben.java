
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
    
    public class Barbero extends Thread {
        
        String name;
        
        public  Barbero(String name){
            this.setName(name);
        }
        
        @Override
        public void run() {
            
            System.out.println("[+] Nombre del barbero: " + this.getName());
            System.err.println("[+] PID del barbero: " + this.getId());
        
            while(true){
                try {
                    
                    /* El babero se queda bloqueado hasta que haya algun cliente listo(en la sala de espera sentado) */
                    clientesEspera.acquire();   
                    
                    /* Peticion para poder modifcar el numero de sillas libres */
                    sillasAccesibles.acquire();
                    nSillasLibres++;
                    
                    /* El barbero señaliza que el sillon esta listo */ 
                    barberoListo.release();
                    
                    /* Señañizamos que no se va a volver a modifcar el valor del numero de sillas libres */
                    sillasAccesibles.release();
                    
                    /* Se procede a cortar el pelo del cliente(hilo) */
                } catch (InterruptedException ex) {
                    Logger.getLogger(BarberoDurmienteRuben.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        }  
    }
    
    public class Cliente extends Thread {
        
        int numeroC;

        public Cliente(int i, String name) {
            this.numeroC = i;
            this.setName(name);
        }
    
        public void run(){
            
            System.out.println("[+] Nombre cliente: " + this.getName());
            System.out.println("[+] PID cliente: " + this.getId());
            System.out.println("[+] Numero cliente: " + this.numeroC);
            
            
            try {

                /* Peticion para poder comprobar si existen sillas libres en la barberia */
                sillasAccesibles.acquire();
               
                /* Al menos existe una silla libre y nos podemos sentar a esperar */
                if (nSillasLibres > 0) {
                    
                    System.out.println("[+] " + this.name  + "-" + this.id + " se ha sentado");
                    nSillasLibres--;

                    /* Se indica que el cliente esta listo para que se le corte el pelo */
                    clientesEspera.release();
                    
                    /* Ya no se va a volver a utilzar el recurso numero de sillas libres */
                    sillasAccesibles.release();
                    
                    /* Se queda bloqueado hasta que el barbero este listo para cortarle el pelo(sillon libre) */
                    barberoListo.acquire();
                    
                    /* Se procede al corte de pelo */
                    cortarPelo();

                } else {    /* No hay sillas libres, el cliente se las pira */
                    
                    System.out.println("[+] No hay sillas libres. Adios " + this.name + " - " + this.id);
                    
                    /* Se libera recurso */ 
                    sillasAccesibles.release();
                }
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
        
        Barbero barbero = new Barbero("Walid");
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
    
    public void cortarPelo(){
        
        Thread t = Thread.currentThread();

        if(t.getName().equals("Walid")){
            
        }
        
        System.out.println("[+] El cliente " + t.getId() + " ha comenzado ha cortarse el pelo");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(BarberoDurmienteRuben.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
}


/* Tener en cuenta que:
 *   - Sempahore.acquire es lo mismo que hacer un wait, es decir, se queda bloqueado(esperando) hasta que algo ocurra.
 *     En este caso que otro hilo deje de utilizar dicho recurso, o lo que es lo mismo, que el cliente que este utilizando
 *     dicho recurso haga un Semaphore.release o finalize su ejecucion 
 *   
 *   - Semaphore.release es lo mismo que hacer un signal, es decir, se manda una señal para indicar algo, en este caso
 *     un aviso. O bien para avisar al barbero que un cliente esta listo para que se le corte el pelo(esta en la sala de espera
 *     sentado) clientesEspera.release, o que el barbero esta listo para cortar el pelo al siguiente cliente(el sillon esta
 *     libre) barberoListo.release. */