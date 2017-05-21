package ObserverPattern;


import MelbourneWeatherTimeLapse.ExceptionException;
import MelbourneWeatherTimeLapse.MelbourneWeatherTimeLapseStub;

import java.rmi.RemoteException;
import java.util.Arrays;


public class Location2  {

    private String[] locations2;

    public Location2() throws RemoteException, ExceptionException {
        final MelbourneWeatherTimeLapseStub MWTimeLapse = new MelbourneWeatherTimeLapseStub();
        MelbourneWeatherTimeLapseStub.GetLocationsResponse Location2Response = MWTimeLapse.getLocations();
        setLocation2(Location2Response.get_return());

    }

    public void setLocation2(String[] Loc2Array) {
        this.locations2 = Loc2Array;
    }

    public String[] getLocations2(){
        return this.locations2;
    }


}

