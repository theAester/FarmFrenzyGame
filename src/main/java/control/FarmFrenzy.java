package control;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.Authenticator;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
public class FarmFrenzy extends Application {
    public static void main(String[] args) throws IOException {
        Authenticator authenticator=new Authenticator();
        Save.initializeSave();
        Load.initializeLoad();
       //Save.GenerateLevel(100,300,450,3000000,400,300,100,3,3);
        launch(args);
        authenticator.Do();

    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
    }
}
