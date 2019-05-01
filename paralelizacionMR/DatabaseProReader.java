package Práctica7.Ejercicio2;
import java.util.concurrent.Semaphore;

public class DatabaseProReader implements Database {

    // https://en.wikipedia.org/wiki/Readers%E2%80%93writers_problem

    private Semaphore semReaders = new Semaphore(1);
    private Semaphore semWriters = new Semaphore(1);
    private static int nbReaders = 0;

    public void startReading() {
        try {
            System.out.println("Read request");
            semReaders.acquire();
            nbReaders++;
            if (nbReaders == 1) {
                semWriters.acquire();
            }
            System.out.println("Read request approved, " + nbReaders + " readers");
            semReaders.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        try {
            System.out.println("Reading");
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void endReading() {
        try {
            semReaders.acquire();
            nbReaders--;
            System.out.println("Finishing read, " + nbReaders + " readers remaining");
            if (nbReaders == 0) {
                System.out.println("Last reader, waking up writers");
                semWriters.release();
            }
            semReaders.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startWriting() {
        try {
            System.out.println("Write request");
            semWriters.acquire();
            System.out.println("Write request approved");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void write() {
        try {
            System.out.println("Writing");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void endWriting() {
        System.out.println("Finishing write, waking up others");
        semWriters.release();
    }
}
