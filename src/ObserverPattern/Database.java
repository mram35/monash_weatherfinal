package ObserverPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Database {


    private static Map map;


    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
    Database.map= map;
    }


}
