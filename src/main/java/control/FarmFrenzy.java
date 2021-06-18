package control;
import view.Authenticator;
import java.io.IOException;
import java.util.ArrayList;
public class FarmFrenzy {
    public static void main(String[] args) throws IOException {
        Authenticator authenticator=new Authenticator();
        Save.initializeSave();
        Load.initializeLoad();
        authenticator.Do();
    }
}
