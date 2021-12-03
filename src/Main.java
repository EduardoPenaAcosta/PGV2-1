public class Main {

    public static void main(String[] args) {

        //Creamos las funciones, que llamarán a las clases...
        Monitor monitor = new Monitor(10);

        Productor plantas = new Productor(monitor, 2, 5000, 8);
        Consumidor consumidores = new Consumidor(monitor, 6);

        //plantas.setPriority(Thread.MAX_PRIORITY);
        plantas.start();
        consumidores.start();


    }
}