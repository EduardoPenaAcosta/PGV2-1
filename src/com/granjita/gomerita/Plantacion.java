package com.granjita.gomerita;

import java.util.ArrayList;

public class Plantacion extends Thread {

    private int clients;
    private int producers;
    private int limitPlants;
    private int plantsGROWING;
    private final static int maxPlantsGROW = 5000;


    private String[] plants = {"Lettuce", "Cabbage", "Onion", "Spinach", "Potato", "Celery",
            "Asparagus", "Radish", "Broccoli", "Artichoke", "Tomato",
            "Cucumber", "Eggplant", "Carrot", "Green Bean"};

    private ArrayList<String> plantsGROWED = new ArrayList<String>();

    public Plantacion(int clients, int producers, int limitPlants, int consumerEats, int plantsGROWING) {
        this.clients = clients;
        this.producers = producers;
        this.limitPlants = limitPlants;
        this.plantsGROWING = plantsGROWING;
    }


    @Override
    public void run() {
        super.run();
        try {
            int randomAccessArrayPlants = ((int) ( Math.random() * plantsGROWED.size()));
            double TIMINGROWING = Math.random() * 900;

            if(this.limitPlants > maxPlantsGROW){
                System.out.println("Es imposible plantar más de 5000 unidades.");
            }else if(this.limitPlants > plantsGROWING){
                System.out.println("No se pueden consumir más plantas que las plantadas.");
            }else{
                for (int i = 0; i < this.plantsGROWING; i++) {
                    int randomAccess = ((int) (Math.random() * 15));

                    sleep((long) TIMINGROWING);
                    System.out.println("La planta: " + this.plants[randomAccess] + " ha crecido con un tiempo de: " + TIMINGROWING + " minutos.");
                    plantsGROWED.add(this.plants[randomAccess]);
                }

                for(int i = 0; i < this.limitPlants;i++){

                    sleep((long) TIMINGROWING);
                    System.out.println("Se ha consumido la verdura: " + plantsGROWED.get(randomAccessArrayPlants) + " por uno de los clientes...");
                    plantsGROWED.remove(randomAccessArrayPlants);
                }

            }
        } catch (Exception e) {
            System.out.println(e);

        }


    }
}
