package ObserverPattern;


import java.util.ArrayList;
import java.util.List;

public class AccumulatedTemperature {

    private static List<String> temperature2 = new ArrayList<String>();
    private static List<String> rainfall2=new ArrayList<String>();



    private static List<String> time = new ArrayList<String>();



    public static void setTemperature(String temperature) {
        temperature2.add(temperature);

    }

    public static void setRainfall(String rainfall){
        rainfall2.add(rainfall);
    }

    public static List<String> getRainfall(){
        return rainfall2;
    }

    public static List<String> getTemperature() {
        return temperature2;
    }

    public static void setTime(String tim) {
        time.add(tim);

    }

    public static List<String> getTime() {
        return time;
    }



}
