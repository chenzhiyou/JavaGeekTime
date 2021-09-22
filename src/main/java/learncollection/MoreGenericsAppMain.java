package learncollection;

import java.util.ArrayList;
import java.util.List;

public class MoreGenericsAppMain {
    public static void main(String[] args) {
        List<Children> g3List = new ArrayList<>();

        extMethod(g3List);

        List<? extends  Parent > g2ListEXt = null;

        g2ListEXt = new ArrayList<Children>();
        g2ListEXt = new ArrayList<Parent>();
//        g2ListEXt = new ArrayList<GrandParent>();
    }
    public static void  extMethod(List<? extends  Parent> exParm){

    }

    public static  void  justG2Method(List<Parent> exPram){

    }

    public static  void supMethod(List<? super Parent> exParm){

    }

}
