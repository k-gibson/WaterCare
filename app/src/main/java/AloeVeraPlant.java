/**
 * Created by kategibson on 5/14/18.
 */

import java.util.Date;

public class AloeVeraPlant extends Plant {

    private long timer;


    AloeVeraPlant(String name) {
        super(name);
        this.name = name;
        this.plantName = "Aloe Vera";
        this.lastWatered =new Date().getTime();
        this.timer = calculateTimer();
    }

    private long calculateTimer(){
        //use aloe vera data and weather to figure out next watering event
        return 1000;
    }
}
