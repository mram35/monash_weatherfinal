package ObserverPattern;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import MelbourneWeather.ExceptionException;
import sun.dc.pr.PRError;

import java.awt.*;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController {


    @FXML private Button searchButton;
    @FXML private Button set;
    @FXML private ChoiceBox<String> locationArr;
    @FXML private ToggleGroup RadioGroup;
    @FXML private RadioButton radio1;
    @FXML private RadioButton radio2;

    private static String chosenServer;



    public void initialize() throws RemoteException, ExceptionException, MelbourneWeatherTimeLapse.ExceptionException {

        radio1.setUserData("Server 1");
        radio2.setUserData("Server 2");

        Location server1Locations = new Location();
        Location2 server2Locations = new Location2();

        RadioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue <? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (RadioGroup.getSelectedToggle()!=null){
                    locationArr.getSelectionModel().clearSelection();
                    locationArr.getItems().clear();
                    if (RadioGroup.getSelectedToggle().getUserData().equals("Server 1")){
                        locationArr.getItems().addAll(server1Locations.getLocations());
                        chosenServer = String.valueOf(RadioGroup.getSelectedToggle().getUserData());
                        //radio2.setDisable(true);
                    }
                    if (RadioGroup.getSelectedToggle().getUserData().equals("Server 2")){
                        locationArr.getSelectionModel().clearSelection();
                        locationArr.getItems().clear();
                        locationArr.getItems().addAll(server2Locations.getLocations2());
                        chosenServer = String.valueOf(RadioGroup.getSelectedToggle().getUserData());


                        //radio1.setDisable(true);
                    }
                }
            }
        });



        searchButton.setDisable(true);

        set.setOnAction((ActionEvent event) -> {

            WeatherStation weatherStation = new WeatherStation();
            weatherStation.init(chosenServer);

            Location newLoc = null;
            try {
                newLoc = new Location();
                newLoc.setLocation(locationArr.getSelectionModel().getSelectedItem());

            } catch (RemoteException | ExceptionException e) {
                e.printStackTrace();
            }

            try {
                WeatherStation.main(null);
            } catch (RemoteException | ExceptionException e) {
                e.printStackTrace();
            }

            searchButton.setDisable(false);
        });

        searchButton.setOnAction((ActionEvent event) -> {

            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("WeatherDisplay.fxml"));

                Parent root = loader.load();



                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setTitle("Weather Forecast");
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {

                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, e);
            }


            searchButton.setDisable(true);

        });
    }

}



