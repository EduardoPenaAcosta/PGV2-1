import java.nio.Buffer;

public class Consumidor extends Thread{

    private final int consumer;
    private Monitor buffer;

    // Constructor del consumidor
    public Consumidor(Monitor buffer, int consumer) {
        this.buffer = buffer;
        this.consumer = consumer;
    }

    // Método del run, donde decimos que estamos consumiendo la verdura x después de un tiempo...
    @Override
    public void run() {
        try{

            for(int i = 0; i < Productor.getPlantasCreciendo(); i++){
                sleep(5000);
                String buyProducts = buffer.Comprar();
                int randomClient = ((int) (Math.random() * consumer));
                System.out.println("El cliente nº " + randomClient + " ha consumido la verdura: " + buyProducts);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
