package Práctica7.Ejercicio2;
import java.util.concurrent.Semaphore;

public class DatabaseProWriter implements Database {

    // https://en.wikipedia.org/wiki/Readers%E2%80%93writers_problem

    private Semaphore rMutex = new Semaphore(1);
    private Semaphore wMutex = new Semaphore(1);
    private Semaphore readTry = new Semaphore(1);
    private Semaphore resource = new Semaphore(1);
    private static int writeCount = 0;
    private static int readCount = 0;

    public void startReading() {
        try {
            System.out.println("Read request");
            readTry.acquire();
            rMutex.acquire();
            readCount++;
            if (readCount == 1) {
                resource.acquire();
            }
            System.out.println("Read request approved, " + readCount + " readers");
            rMutex.release();
            readTry.release();
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
            rMutex.acquire();
            readCount--;
            System.out.println("Finishing read, " + readCount + " readers remaining");
            if (readCount == 0) {
                System.out.println("Last reader, waking up writers");
                resource.release();
            }
            rMutex.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startWriting() {
        try {
            System.out.println("Write request");
            wMutex.acquire();
            writeCount++;
            if (writeCount == 1) {
                readTry.acquire();
                System.out.println("First writer arrived, locking new readers");
            }
            wMutex.release();
            resource.acquire();
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
        System.out.println("Finishing write");
        try {
            resource.release();
            wMutex.acquire();
            writeCount--;
            if (writeCount == 0) {
                System.out.println("No more writers waiting, waking up readers");
                readTry.release();
            }
            wMutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
