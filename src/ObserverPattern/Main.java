package ObserverPattern;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {


    public static void main(String[] args) throws  Exception  {

        Application.launch(Main.class,(java.lang.String[])null );
    }

    public void start(Stage mainsStage) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindowGui.fxml"));
            Pane page = loader.load();

            Scene scene = new Scene(page);

            mainsStage.setTitle("Weather Forecast");
            mainsStage.setScene(scene);
            mainsStage.show();
        }
        catch (Exception e) {

            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}