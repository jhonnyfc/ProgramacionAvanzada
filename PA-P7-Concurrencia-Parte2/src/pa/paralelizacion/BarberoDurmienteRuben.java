
package pa.paralelizacion;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rabiixx on 23/04/2019
 */
public class BarberoDurmienteRuben {
    
    Semaphore barberoListo = new Semaphore(0);           // Mutex 0, 1
    Semaphore sillasAccesibles = new Semaphore(1);      // Si es 1, el numero de sillas puede ser modficado 
    Semaphore clientesEspera = new Semaphore(0);        // Numero de clientes sentados, listos para ser atendidos
    int nSillasLibres = 5;                        // Numero de clientes 
    
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
            
            System.out.println("[+] El barbero esta cortando el pelo");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BarberoDurmienteRuben.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }
  
    }
    
    public class Cliente extends Thread {
    
        public void run(){
            while(true){
                try {
                    sillasAccesibles.acquire();
                    if (nSillasLibres > 0) {
                        nSillasLibres--;
                        clientesEspera.release();
                        sillasAccesibles.release();
                        barberoListo.acquire();
                        this.cortarPelo();
                    } else {
                        
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(BarberoDurmienteRuben.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }

    
    
    }
    
}
/*
def Customer():
  while true:                   # Run in an infinite loop to simulate multiple customers.
    wait(accessWRSeats)         # Try to get access to the waiting room chairs.
    if numberOfFreeWRSeats > 0: # If there are any free seats:
      numberOfFreeWRSeats -= 1  #   sit down in a chair
      signal(custReady)         #   notify the barber, who's waiting until there is a customer
      signal(accessWRSeats)     #   don't need to lock the chairs anymore
      wait(barberReady)         #   wait until the barber is ready
      # (Have hair cut here.)
    else:                       # otherwise, there are no free seats; tough luck --
      signal(accessWRSeats)     #   but don't forget to release the lock on the seats!
      # (Leave without a haircut.)



# The first two are mutexes (only 0 or 1 possible)
Semaphore barberReady = 0
Semaphore accessWRSeats = 1     # if 1, the number of seats in the waiting room can be incremented or decremented
Semaphore custReady = 0         # the number of customers currently in the waiting room, ready to be served
int numberOfFreeWRSeats = N     # total number of seats in the waiting room

def Barber():
  while true:                   # Run in an infinite loop.
    wait(custReady)             # Try to acquire a customer - if none is available, go to sleep.
    wait(accessWRSeats)         # Awake - try to get access to modify # of available seats, otherwise sleep.
    numberOfFreeWRSeats += 1    # One waiting room chair becomes free.
    signal(barberReady)         # I am ready to cut.
    signal(accessWRSeats)       # Don't need the lock on the chairs anymore.
    # (Cut hair here.)



*/