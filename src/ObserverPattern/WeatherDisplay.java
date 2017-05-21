package ObserverPattern;

import MelbourneWeather.ExceptionException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class WeatherDisplay implements Initializable  {


    @FXML private Label txtLocation;
    @FXML private Label temperature;
    @FXML private Label rainfall;
    @FXML private Label time;
    @FXML private Button refresh;
    @FXML private SplitMenuButton viewType;
    @FXML private ImageView weatherImage;





    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {
            Location location1 = new Location();
            txtLocation.setText(location1.getLocation());
        } catch (RemoteException | ExceptionException e) {
            e.printStackTrace();
        }

        Temperature temperature1 = new Temperature();
        temperature.setText(String.valueOf(temperature1.getTemp()));
        time.setText(temperature1.getTime());

        Rainfall rainfall1 = new Rainfall();
        rainfall.setText(String.valueOf(rainfall1.getRain()));

        if(rainfall1.getRain() <= 0 && temperature1.getTemp() > 0) {

            Image image1 =new Image("ObserverPattern/Images/sun.png");
            weatherImage.setImage(image1);
        }
        if (rainfall1.getRain() > 0 && temperature1.getTemp() > 0) {
            Image image2 = new Image("ObserverPattern/Images/slightly_raining.png");
            weatherImage.setImage(image2);
        }





    }


    public void refressh(MouseEvent mouseEvent) {
        try {
            Location location1 = new Location();
            String key = location1.getLocation();

            Database database = new Database();
            Map map = database.getMap();
            List list= (List) map.get(key);

            time.setText((String) list.get(0));
            temperature.setText((String) list.get(1)) ;
            rainfall.setText((String) list.get(2));

            //set image
            if(Double.valueOf(String.valueOf(list.get(2))) <= 0 &&  (Double.valueOf(String.valueOf(list.get(1))) > 0)) {

                Image image1 =new Image("ObserverPattern/Images/sun.png");
                weatherImage.setImage(image1);
            } else if ((Double.valueOf(String.valueOf(list.get(2)))) > 0 && (Double.valueOf(String.valueOf(list.get(1))) > 0)) {
                Image image2 = new Image("ObserverPattern/Images/slightly_raining.png");
                weatherImage.setImage(image2);
            }




        } catch (RemoteException | ExceptionException e) {
            e.printStackTrace();
        }


    }


    public void tempGraphicalView(ActionEvent actionEvent) {

        TemperatureGraph.main(null);

    }

    public void rainGraphicalView(ActionEvent actionEvent) {

        RainfallGraph.main(null);

    }
}
