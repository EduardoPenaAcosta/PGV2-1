public class Productor extends Thread {


    // Atributos creados
    private final int productor;
    private Monitor buffer;
    private final int limitePlantacion;
    private static int plantasCreciendo;
    // String de verduras
    private String [] Verduras = {
            "lettuce", "cabbage", "onion", "spinach", "potato", "celery", "asparagus", "radish",
            "broccoli", "artichoke", "tomato", "cucumber", "eggplant", "carrot", "green bean"};


    // Constructor
    public Productor(Monitor buffer, int productor, int limitePlantacion, int plantasCreciendo) {
        this.buffer = buffer;
        this.productor = productor;
        this.limitePlantacion = limitePlantacion;
        this.plantasCreciendo = plantasCreciendo;
    }


    // Método para obtener las plantas creciendo
    public static int getPlantasCreciendo() {
        return plantasCreciendo;
    }

    // Método run, para comprobar las plantas en crecimiento, si excede, devuelve un error
    // En caso de ser correcto, creamos una verdura con su tiempoo de crecimiento..
    @Override
    public void run() {
        try {
            if (this.plantasCreciendo > this.limitePlantacion) {
                throw new Error("Se ha excedido el límite de plantas disponibles.");
            } else {
                for (int i = 0; i < this.plantasCreciendo; i++) {
                    sleep(2000);
                    int verdura = (int) (Math.random() * this.Verduras.length);
                    String misVerduras = Verduras[verdura];
                    int tiempoCrecimiento = (int) (Math.random() * 900);
                    int productorRandom = ((int) (Math.random() * this.productor));
                    sleep(tiempoCrecimiento);
                    buffer.Producir(misVerduras);
                    System.out.println("La verdura " + misVerduras +"  ha sido cosechada por el productor nº " +
                            productorRandom + " y ha crecido con un tiempo de: " + tiempoCrecimiento + " minutos");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}