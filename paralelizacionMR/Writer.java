package Práctica7.Ejercicio2;
public class Writer<main> implements Runnable {

    private Database database;

    public Writer(Database database) {
        this.database = database;
    }

    @Override
    public void run() {
        for(int i=0;i<4;i++) {
            database.startWriting();
            database.write();
            database.endWriting();
        }
    }

    public static void main(String[] args) {
        Database database = new DatabaseProWriter();
       // Database database = new DatabaseProReader();

        Thread w1 = new Thread(new Writer(database));
        Thread w2 = new Thread(new Writer(database));

        Thread r1 = new Thread(new Reader(database));
        Thread r2 = new Thread(new Reader(database));
        Thread r3 = new Thread(new Reader(database));
        Thread r4 = new Thread(new Reader(database));

        w1.start();
        w2.start();

        r1.start();
        r2.start();
        r3.start();
        r4.start();
    }
}
