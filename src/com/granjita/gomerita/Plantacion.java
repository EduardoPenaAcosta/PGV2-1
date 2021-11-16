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
            double TIMINGROWING = 12;

            if(this.limitPlants > maxPlantsGROW){
                System.out.println("Es imposible plantar más de 5000 unidades.");
            }else if(this.limitPlants > plantsGROWING){
                System.out.println("No se pueden consumir más plantas que las plantadas.");
            }else{
                for(int i = 0; i < this.producers; i++){
                    System.out.println("El productor " + i + " ha plantado las siguientes verduras: ");
                    for (int h = 0; h < this.plantsGROWING; h++) {
                        int randomAccess = ((int) (Math.random() * 15));
                        TIMINGROWING = Math.random() * 900;

                        sleep((long) TIMINGROWING);
                        System.out.println("La planta: " + this.plants[randomAccess] + " ha crecido con un tiempo de: " + TIMINGROWING + " minutos.");
                        plantsGROWED.add(this.plants[randomAccess]);
                    }

                    System.out.println("Y han sido consumidas:");
                    for(int x = 0; x < this.limitPlants;x++){

                        TIMINGROWING = Math.random() * 900;
                        int randomClient = (int)(Math.random()*this.clients);
                        sleep((long) TIMINGROWING);
                        System.out.println("Se ha consumido la verdura: " + plantsGROWED.get(randomAccessArrayPlants) + " por el cliente " + randomClient);
                        plantsGROWED.remove(randomAccessArrayPlants);
                    }
                }


            }
        } catch (Exception e) {
            System.out.println(e);

        }


    }
}
