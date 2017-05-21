package ObserverPattern;

import MelbourneWeather.ExceptionException;
import org.apache.regexp.RE;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class WeatherData implements Subject {


    private ArrayList observers;
    private  Double temperature;
    private  Double rainfall;
    private  String time;

    public WeatherData() {
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }
    @Override
    public void notifyObservers() throws IOException, ExceptionException {
        for (Object observer1 : observers) {
            Observer observer = (Observer) observer1;
            observer.update(temperature, rainfall, time);
        }
        }

    public void measurementsChanged() throws IOException, ExceptionException {
        notifyObservers();
    }


    public void setMeasurements(Double temp, Double rain, String tim) throws
            IOException, ExceptionException {
        this.temperature = temp;
        this.rainfall = rain;
        this.time = tim;
        measurementsChanged();

    }
}

