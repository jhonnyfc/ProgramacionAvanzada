/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.p7;

    import java.util.concurrent.*;

/**
 *
 * @author alumno
 */

public class Example extends Thread{

  public static Semaphore clientes = new Semaphore(0);
  public static Semaphore barbero = new Semaphore(0);
  public static Semaphore sillasAccesibles = new Semaphore(1);
  
  public static final int SILLAS = 4;
  public static final int NUMERO_CLIENTES = 10;
  
  public static int sillasLibres = SILLAS;
  
  class Cliente extends Thread {
    int iD;
    boolean noCortado = true;
    
    public Cliente (int i){
      iD = i;
    }
    
    public void run(){
      while(noCortado) {
        try{
          sillasAccesibles.acquire();
          if(sillasLibres>0) {
            System.out.println("El cliente #" + iD + " se ha sentado.");
            sillasLibres--;
            clientes.release();
            sillasAccesibles.release();
            try{
              barbero.acquire();
              noCortado = false;
              this.cortarPelo();
            }
            catch(InterruptedException e){
              System.err.print("capturada una InterruptedException en ");
              System.err.println("el Cliente@run() esperando al barbero");
              System.err.println("--- Mensaje: " + e);
              e.printStackTrace(System.err);
              System.exit(1);
            }
          }
          else{
            System.out.println("No hay sillas libres. Sale #"+iD);
            sillasAccesibles.release();
            noCortado = false;
          }
        }
        catch(InterruptedException e){
          System.err.print("capturada una InterruptedException en ");
          System.err.println("el Cliente@run()");
          System.err.println("--- Mensaje: " + e);
          e.printStackTrace(System.err);
          System.exit(1);
        }
      }
    }
    
    public void cortarPelo() {
      System.out.println("Al cliente #" + iD + " se le está cortando el pelo");
      try{
        Thread.sleep(5000);
      }
      catch(InterruptedException e){
        System.err.print("capturada una InterruptedException en ");
        System.err.println("el Cliente@cortarPelo()");
        System.err.println("--- Mensaje: " + e);
        e.printStackTrace(System.err);
        System.exit(1);
      }   
    }
  }

  class Barbero extends Thread {
    Barbero() {}
    
    public void run(){
      while (true) {
        try{
          clientes.acquire();
          sillasAccesibles.acquire();
          sillasLibres++;
          barbero.release();
          sillasAccesibles.release();
          this.cortaPelo();
        }
        catch(InterruptedException e){
          System.err.print("capturada una InterruptedException en ");
          System.err.println("el Barbero@run()");
          System.err.println("--- Mensaje: " + e);
          e.printStackTrace(System.err);
          System.exit(1);
        }          
      }
    }
    
    public void cortaPelo(){
      System.out.println("El barbero esta cortando el pelo");
      try{
        Thread.sleep(5000);
      }
      catch(InterruptedException e){
        System.err.print("capturada una InterruptedException en ");
        System.err.println("el Barbero@cortaPelo()");
        System.err.println("--- Mensaje: " + e);
        e.printStackTrace(System.err);
        System.exit(1);
      }   
      
    }
  }
  
  //metodo main
  public static void main(String[] args) {
    Example barberia = new Example();
    barberia.start();
  }
  
  //metodo run de barbero BarberoDurmiente
  public void run(){
    Barbero paco = new Barbero();
    paco.start();
    
    for (int i = 1 ; i<= NUMERO_CLIENTES; i++) {
      Cliente unCliente = new Cliente(i);
      unCliente.start();
      
      try{
        Thread.sleep(2000);
      }
      catch(InterruptedException e){
        System.err.print("capturada una InterruptedException en ");
        System.err.println("el BarberoDurmiente@run()");
        System.err.println("--- Mensaje: " + e);
        e.printStackTrace(System.err);
        System.exit(1);
      }   
      
    }
  
  }
  
}
