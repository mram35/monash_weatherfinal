package ObserverPattern;

import MelbourneWeather.ExceptionException;
import javafx.fxml.FXML;

import java.awt.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WeatherStation extends TimerTask {

    public static String chosenLocation;
    public static String finalchosenServer;

    public static double temp;
    public static double rain;
    public static String time;





    public static void main(String[] args) throws RemoteException, ExceptionException {

        Location location = new Location();
        chosenLocation = location.getLocation();




        Timer timer = new Timer();
        timer.schedule(new WeatherStation(), 0, 5 * 60000);
    }


    @Override
    public void run() {

        WeatherData weatherData = new WeatherData();

        if (finalchosenServer.equals("Server 1")) {
            Temperature temperature = new Temperature();
            Rainfall rainfall = new Rainfall();

            try {
                temperature.setTemperature(chosenLocation);
                rainfall.setRainfall(chosenLocation);

                temp = temperature.getTemperature();
                rain = rainfall.getRainfall();
                time = temperature.getTime();

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        if (finalchosenServer.equals("Server 2")) {

            Weather2 weather2 = new Weather2();
            try {
                weather2.setWeather(chosenLocation);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (MelbourneWeatherTimeLapse.ExceptionException e) {
                e.printStackTrace();
            }
            temp = Double.parseDouble(weather2.getTemperature());
            System.out.println(temp);
            rain = Double.parseDouble(weather2.getRainfall());
            time = weather2.getTime();

        }

        try {


            CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

            weatherData.setMeasurements(temp, rain, time);

        } catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger(CurrentConditionsDisplay.class.getName()).log(Level.SEVERE, null, e);
        }


    }


    public void init(String chosenServer) {
        finalchosenServer = chosenServer;
    }
}
