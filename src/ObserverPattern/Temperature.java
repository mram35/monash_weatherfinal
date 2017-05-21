package ObserverPattern;

import MelbourneWeather.MelbourneWeather2Stub;

public class Temperature  {


    private  Double tempVal;
    private static String time;

    private static Double temp;


    public void setTemperature(String locationChoice) throws Exception{
        final MelbourneWeather2Stub MelbourneWeather = new MelbourneWeather2Stub();
        MelbourneWeather2Stub.GetTemperature tempReq = new MelbourneWeather2Stub.GetTemperature();

        tempReq.setLocation(locationChoice);

        MelbourneWeather2Stub.GetTemperatureResponse temperatureResponse = MelbourneWeather.getTemperature(tempReq);
        String[] temp = (temperatureResponse.get_return());
        tempVal = Double.parseDouble(temp[1]);
        setTime(temp[0]);

    }

    public Double getTemperature() throws Exception {
        return tempVal;
    }


    public void setTime(String time){
        Temperature.time = time;
    }

    public String getTime() {
        return time;
    }

    public Double getTemp(){
        return temp;
    }

    public void setTemp(Double temp) {
        Temperature.temp = temp;

    }




}
