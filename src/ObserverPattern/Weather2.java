package ObserverPattern;

import MelbourneWeatherTimeLapse.ExceptionException;
import MelbourneWeatherTimeLapse.MelbourneWeatherTimeLapseStub;

import java.rmi.RemoteException;

public class Weather2 {
    private String[] tempVal;
    private String locationChoice;
    private static String time;
    private static String temperature;
    private static String rainfall;



    public void setWeather(String locationChoice) throws RemoteException, ExceptionException{
        //temperature
        final MelbourneWeatherTimeLapseStub MWTimeLapse2 = new MelbourneWeatherTimeLapseStub();
        MelbourneWeatherTimeLapseStub.GetWeather yoo=new MelbourneWeatherTimeLapseStub.GetWeather();
        yoo.setLocation(locationChoice);

        MelbourneWeatherTimeLapseStub.GetWeatherResponse response=MWTimeLapse2.getWeather(yoo);

        tempVal = response.get_return();
        setTime(tempVal[0]);

        double temp = Double.parseDouble(tempVal[1]);
        double temp2farenheit =  ((temp - 273.15f));
        setTemperature(String.valueOf(temp2farenheit));

        setRainfall(tempVal[2]);


    }



    public void setTime(String Time){
        time = Time;

    }

    public String getTime(){
        return time;
    }

    public void setTemperature(String Temperature){
        temperature = Temperature;

    }

    public String getTemperature(){
        return temperature;
    }

    public void setRainfall(String Rainfall){
        rainfall = Rainfall;

    }

    public String getRainfall(){
        return rainfall;
    }




}