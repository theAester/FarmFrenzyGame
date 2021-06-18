package control;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import control.*;
import model.Animal;
import model.Commodity;
import model.Facility;
import model.Threat;
import view.Printer;
public class Load {
    static ArrayList<User> userList=new ArrayList<>();
    static ArrayList<Level> levelList=new ArrayList<>();
    static Gson gson;
    public Load() {
    }
    public static void initializeLoad(){
        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(Animal.class, new InterfaceAdapter<Animal>());
        gb.registerTypeAdapter(Threat.class, new InterfaceAdapter<Threat>());
        gb.registerTypeAdapter(Facility.class, new InterfaceAdapter<Facility>());
        gb.registerTypeAdapter(Commodity.class, new InterfaceAdapter<Commodity>());
        gson = gb.create();
    }
    public static ArrayList<User> UserList()
    {
            try {
                String Read = "";
                File ReadUserList = new File("UserArrayList.json");
                Scanner scanner = new Scanner(ReadUserList);
                while (scanner.hasNextLine()) {
                    Read += scanner.nextLine();
                }
                scanner.close();
                gson = new Gson();
                userList= gson.fromJson(Read,new TypeToken<ArrayList<User>>(){}.getType());
            }
            catch (IOException ioException){
                Printer.DamagedFile("UserArrayList.json");
            }
            return userList;
    }
    public static ArrayList<Level> LevelList() throws FileNotFoundException {
        String Read="";

        File ReadLevelList=new File("LevelArrayList.json");
        Scanner scanner=new Scanner(ReadLevelList);
        while(scanner.hasNextLine())
        {
            Read+=scanner.nextLine();
        }
        scanner.close();
        Gson gson=new Gson();
        levelList=gson.fromJson(Read,new TypeToken<ArrayList<Level>>(){}.getType());
        return  levelList;
    }

}
