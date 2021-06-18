package control;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
public class Save {
static Gson gson=new Gson();

    public Save() {
    }
    public static void UserList(ArrayList<User> userList) {
        String UserArrayList=gson.toJson(userList,new TypeToken<ArrayList<User>>(){}.getType());
        try {
            FileWriter userArrayListWriter = new FileWriter("UserArrayList.json");
            userArrayListWriter.write(UserArrayList);
            userArrayListWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void LevelList(ArrayList<Level> levelList) throws IOException {
        String LevelArrayList=gson.toJson(levelList);
        FileWriter levelArrayList=new FileWriter("LevelArrayList.json");
        levelArrayList.write(LevelArrayList);
        levelArrayList.close();
    }
}
