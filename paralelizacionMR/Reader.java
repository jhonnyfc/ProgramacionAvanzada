package Práctica7.Ejercicio2;
public class Reader implements Runnable {

    private Database database;

    public Reader(Database database) {
        this.database = database;
    }

    @Override
    public void run() {
        for(int i=0;i<4;i++) {
            database.startReading();
            database.read();
            database.endReading();
        }
    }
}
