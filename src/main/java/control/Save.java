package control;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Save {
    static Gson gson = new Gson();

    public Save() {
    }

    public static void UserList(ArrayList<User> userList) {
        String UserArrayList = gson.toJson(userList, new TypeToken<ArrayList<User>>() {
        }.getType());
        try {
            FileWriter userArrayListWriter = new FileWriter("UserArrayList.json");
            userArrayListWriter.write(UserArrayList);
            userArrayListWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LevelList(ArrayList<Level> levelList) throws IOException {
        String LevelArrayList = gson.toJson(levelList);
        FileWriter levelArrayList = new FileWriter("LevelArrayList.json");
        levelArrayList.write(LevelArrayList);
        levelArrayList.close();
    }
    public static void GenerateLevel(int numLevel,int startGoldTime,int startSilverTime,int startBronzeTime,int goldStar,int silverStar,int brozeStar,int boundChicken,int boundThreats) {
        ArrayList<Level> levels = new ArrayList<>();
        int SGT=startGoldTime,SST=startSilverTime,SBT=startBronzeTime;
        Random random =new Random();
        for (int i = numLevel; i >=1; i--){
            SGT+=random.nextInt(2)*30;
            SST+=random.nextInt(2)*30;
            SBT+=random.nextInt(2)*30;
            ArrayList<Animal> animalCycle=new ArrayList<>();
            int numChicken=random.nextInt(boundChicken);
            for(int i=0;i<numChicken;i++) {
                Chicken chicken = new Chicken();
                animalCycle.add(chicken);
            }
            ArrayList<Facility> facilityCycle=new ArrayList<>();
            HashMap<Threat,Integer> threats=new HashMap<>();
            int numThreats=random.nextInt(boundThreats);
            for(int i=0;i<numThreats;i++)
            {
                if(random.nextInt()%5==0)
                {
                    Bear bear = new Bear();
                    threats.put(bear,random.nextInt(SGT));
                }
                else if(random.nextInt()%5==1)
                {
                    Tiger tiger=new Tiger();
                    threats.put(tiger, random.nextInt(SGT));
                }
                else{
                    Lion lion=new Lion();
                    threats.put(lion, random.nextInt(SGT));
                }
            }
            HashMap<String,Integer> goals=new HashMap<>();
            goals.put("Money",random.nextInt(5000));
            Level level=new Level(i,SGT, SST,SBT,goldStar* random.nextInt(100)/80,silverStar*random.nextInt(100)/80,brozeStar*random.nextInt(100)/80,animalCycle,threats,facilityCycle,goals, random.nextInt(300));
        }
        try {
            LevelList(levels);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}