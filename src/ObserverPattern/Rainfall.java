package ObserverPattern;

import MelbourneWeather.MelbourneWeather2Stub;

import java.util.ArrayList;

public class Rainfall  {


    private Double rainfallVal;
    private static Double rain;



    public void setRainfall(String locationChoice) throws Exception{

        final MelbourneWeather2Stub MelbourneWeather = new MelbourneWeather2Stub();
        MelbourneWeather2Stub.GetRainfall RainfallRequest = new MelbourneWeather2Stub.GetRainfall();
        RainfallRequest.setLocation(locationChoice);
        MelbourneWeather2Stub.GetRainfallResponse RainfallResponse = MelbourneWeather.getRainfall(RainfallRequest);
        String[] rainfall = ((RainfallResponse.get_return()));
        rainfallVal = Double.parseDouble(rainfall[1]);


    }

    public Double getRainfall() throws Exception {
        return rainfallVal;
    }

    public Double getRain(){
        return rain;
    }

    public void setRain(Double rain) {
        Rainfall.rain = rain;

    }


}
