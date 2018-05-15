/**
 * Created by kategibson on 5/14/18.
 */
import java.util.Date;

public class Plant {
    protected String name = null;
    protected String plantName;
    protected long lastWatered;

    Plant(String name){
        this.name = name;
        plantName = null;
        lastWatered = new Date().getTime();
    }

    public String getName(){
        return name;
    }

    public String getPlantName(){
        return plantName;
    }
}
