package control;
import view.Authenticator;
import java.io.IOException;
import java.util.ArrayList;
public class FarmFrenzy {
    public static void main(String[] args) throws IOException {
        Authenticator authenticator=new Authenticator();
        Save.initializeSave();
        Load.initializeLoad();
       //Save.GenerateLevel(100,300,450,3000000,400,300,100,3,3);
        authenticator.Do();

    }
}
