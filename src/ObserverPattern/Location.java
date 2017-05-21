package ObserverPattern;
import MelbourneWeather.ExceptionException;
import MelbourneWeather.MelbourneWeather2Stub;

import java.rmi.RemoteException;

public class Location {

    public String[] locations;
    public static String location;


    public Location() throws RemoteException, ExceptionException {

        final MelbourneWeather2Stub MelbourneWeather = new MelbourneWeather2Stub();
        MelbourneWeather2Stub.GetLocationsResponse LocationsResponse = MelbourneWeather.getLocations();
        setLocations(LocationsResponse.get_return());

    }


    public String[] getLocations() {

        return locations;

    }

    public void setLocations(String[] locationArray) {

        this.locations = locationArray;

    }

    public String getLocation() {
        return location;

    }

    public void setLocation(String location) {
        Location.location = location;
    }

}
