package control;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import control.*;
import view.Printer;
public class Load {
    static ArrayList<User> userList=new ArrayList<>();
    static Gson gson=new Gson();
    public Load() {
    }
    public static ArrayList<User> UserList()
    {
            try {
                Reader reader= Files.newBufferedReader(Paths.get("../UserArrayList.json"));
            } catch (IOException e) {
                Printer.DamagedFile("UserArrayList.json");
            }
            try {
                userList= gson.fromJson(Reader.nullReader(),new TypeToken<ArrayList<User>>(){}.getType());
            }
            catch (Exception gsonException)
            {
                Printer.DamagedFile("UserArrayList.json");
            }
            return userList;
    }
}
