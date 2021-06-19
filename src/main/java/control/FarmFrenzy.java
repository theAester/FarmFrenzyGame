package control;
import view.Authenticator;
import java.io.IOException;
import java.util.ArrayList;
public class FarmFrenzy {
    public static void main(String[] args) throws IOException {
        Authenticator authenticator=new Authenticator();
        Save.initializeSave();

        Load.initializeLoad();
        Save.GenerateLevel(20,120,150,180,100,80,60,3,12);
        authenticator.Do();

    }
}
