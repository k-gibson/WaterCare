package com.example.kathrinegibson.watercare;

import java.util.ArrayList;

public class Plant {
    private String name;
    private int imagePath;
    private PlantType plantType;

    public Plant(String name, int imagePath, PlantType plantType) {
        this.name = name;
        this.imagePath = imagePath;
        this.plantType = plantType;
    }

    public Plant(PlantType plantType) {
        for(Plant p : possiblePlants){
            if(p.plantType == plantType){
                this.name = "";
                this.imagePath = p.imagePath;
                this.plantType = plantType;
                return;
            }
        }

        this.name = null;
        this.imagePath = -1;
        this.plantType = PlantType.Default;
    }

    static private ArrayList<Plant> possiblePlants = new ArrayList<>();

    //sets up all the possibilities for plants
    static {
        possiblePlants.add(new Plant(null, R.drawable.aloe, PlantType.AloeVera));
        possiblePlants.add(new Plant(null, R.drawable.rose, PlantType.Rose));
    }

    public void changePlantName(String newName){
        this.name = newName;
    }

    public String getName(){
        return "\"" + name + "\"";
    }

    public int getImagePath(){
        return imagePath;
    }

    public String getPlantType() {
        return plantType.toString();
    }
}