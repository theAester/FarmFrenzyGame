package control;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import control.*;
import view.Printer;
public class Load {
    static ArrayList<User> userList=new ArrayList<>();
    static ArrayList<Level> levelList=new ArrayList<>();
    static Gson gson=new Gson();
    public Load() {
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
