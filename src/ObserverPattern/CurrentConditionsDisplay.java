package ObserverPattern;

import MelbourneWeather.ExceptionException;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.*;


public class CurrentConditionsDisplay implements Observer {

    private  Double temp;
    private Double rain;
    private String Tim;
    private Subject weatherData;
    private String chosen;
    private  Double Temp;



    public CurrentConditionsDisplay(Subject weatherData) throws RemoteException, ExceptionException {

        this.weatherData = weatherData;
        weatherData.registerObserver(this);

        Location location = new Location();
        chosen = location.getLocation();
    }


    @Override
    public void update (Double temperature, Double rainfall, String time) throws
            IOException, ExceptionException {
        this.temp = temperature;
        this.rain = rainfall;
        this.Tim = time;



        Temperature temperature1 = new Temperature();
        temperature1.setTemp(temp);

        temperature1.setTime(Tim);

        Rainfall rainfall1 = new Rainfall();
        rainfall1.setRain(rain);

        List<String> weather = Arrays.asList(Tim, String.valueOf(temp) , String.valueOf(rain));
        Map<String, List<String>> map = new HashMap<>();
        map.put(chosen, weather);
        Database map2 = new Database();
        map2.setMap(map);


        AccumulatedTemperature.setTemperature(String.valueOf(temp));
        AccumulatedTemperature.setRainfall(String.valueOf(rain));
        AccumulatedTemperature.setTime(Tim);





    }




}





