package com.example.kathrinegibson.watercare;

import java.util.ArrayList;

public class Plant {
    private String name;
    private String imagePath;
    private PlantType plantType;

    public Plant(String name, String imagePath, PlantType plantType) {
        this.name = name;
        this.imagePath = imagePath;
        this.plantType = plantType;
    }

    public Plant(PlantType plantType) {
        for(Plant p : possiblePlants){
            if(p.plantType == plantType){
                this.name = null;
                this.imagePath = p.imagePath;
                this.plantType = plantType;
                return;
            }
        }

        this.name = null;
        this.imagePath = null;
        this.plantType = PlantType.Default;
    }

    static private ArrayList<Plant> possiblePlants = new ArrayList<Plant>();

    //sets up all the possibilities for plants
    static {
        possiblePlants.add(new Plant(null, "aloe.jpg", PlantType.AloeVera));
        possiblePlants.add(new Plant(null, "rose.jpg", PlantType.Rose));
    }

    public void changePlantName(String newName){
        this.name = newName;
    }

/*
    public static void main(String[] args) {
        com.example.kathrinegibson.watercare.Plant myPlant = new com.example.kathrinegibson.watercare.Plant(com.example.kathrinegibson.watercare.PlantType.Rose);
        System.out.println(myPlant.imagePath);
    }*/
}