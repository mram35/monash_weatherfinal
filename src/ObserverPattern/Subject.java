package ObserverPattern;

import MelbourneWeather.ExceptionException;

import java.io.IOException;
import java.rmi.RemoteException;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers() throws IOException, ExceptionException;
}
