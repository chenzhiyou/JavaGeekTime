package simpleDotGame;

import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;
    public String checkYourself(String userInput){
        int index = locationCells.indexOf(userInput);
        String result = "miss";
        if (index >=0){
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result = "kill";
                System.out.println("Ouch! you sunk" + name + ":(");
            }else {
                return "hit";
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocationCells(ArrayList<String> loc){
        locationCells = loc;
    }


}
