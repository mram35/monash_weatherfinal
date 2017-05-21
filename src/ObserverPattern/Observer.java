package ObserverPattern;

import MelbourneWeather.ExceptionException;

import java.io.IOException;
import java.rmi.RemoteException;

public interface Observer {

    public void update(Double temperature, Double rainfall, String time) throws IOException, ExceptionException;

}
