package control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Save {
    static Gson gson;

    public Save() {
    }
    public static void initializeSave(){
        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(Animal.class, new InterfaceAdapter<Animal>());
        gb.registerTypeAdapter(Threat.class, new InterfaceAdapter<Threat>());
        gb.registerTypeAdapter(Facility.class, new InterfaceAdapter<Facility>());
        gb.registerTypeAdapter(Commodity.class, new InterfaceAdapter<Commodity>());
        gson = gb.create();
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
            SST=SGT+random.nextInt(2)*30+1;
            SBT=SST+random.nextInt(2)*30+2;
            ArrayList<Animal> animalCycle=new ArrayList<>();
            int numChicken=random.nextInt(boundChicken);
            for(int j=0;j<numChicken;j++) {
                Chicken chicken = new Chicken();
                animalCycle.add(chicken);
            }
            ArrayList<Facility> facilityCycle=new ArrayList<>();
            HashMap<Integer,String> threats=new HashMap<>();
            int numThreats=random.nextInt(boundThreats);
            for(int k=0;k<numThreats;k++)
            {
                if(random.nextInt()%5==0)
                {
                    threats.put(random.nextInt(SGT),"bear");
                }
                else if(random.nextInt()%5==1)
                {
                    Tiger tiger=new Tiger();
                    threats.put( random.nextInt(SGT),"tiger");
                }
                else{
                    Lion lion=new Lion();
                    threats.put( random.nextInt(SGT),"lion");
                }
            }
            HashMap<String,Integer> goals=new HashMap<>();
            goals.put("money",random.nextInt(5000));
            goldStar*=random.nextInt(100)/40;
            silverStar=goldStar* random.nextInt(40)/40;
            brozeStar=silverStar*random.nextInt(40)/40;
            Level level=new Level(i,SGT, SST,SBT,goldStar+10,silverStar+10,brozeStar+10,animalCycle,threats,facilityCycle,goals, 100+random.nextInt(200));
           levels.add(level);
        }
/*        try {
            String LevelArrayList = gson.toJson(levels);
            FileWriter levelArrayList = new FileWriter("LevelArrayList.json");
            levelArrayList.write(LevelArrayList);
            levelArrayList.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}