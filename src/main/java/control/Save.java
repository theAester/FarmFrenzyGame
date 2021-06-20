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
            ArrayList<Facility> facilityCycle=new ArrayList<>();
            ArrayList<Animal> animalCycle=new ArrayList<>();
            HashMap<Integer,String> threats=new HashMap<>();
            HashMap<String,Integer> goals=new HashMap<>();
            SGT+=random.nextInt(2)*30;
            SST=SGT+(random.nextInt(2)+1)*30;
            SBT=SST+(random.nextInt(2)+2)*30;
            int numChicken=random.nextInt(boundChicken);
            for(int j=0;j<numChicken;j++) {
                goals.put("egg",random.nextInt(10));
                Chicken chicken = new Chicken();
                animalCycle.add(chicken);
            }
            boolean eggpowder=false;
            boolean bread=false;
            for(int f= random.nextInt(10);f<5;f+=5)
            {
                eggpowder=true;
                EggPowder eggPowder=new EggPowder();
                eggPowder.level=1;
                facilityCycle.add(eggPowder);
                goals.put("powder",random.nextInt(10));
                for(int g= random.nextInt(10);g<5;g+=5)
                {
                    bread=true;
                    goals.put("bread",random.nextInt(10));
                    Bakery bakery=new Bakery();
                    bakery.level=1;
                    facilityCycle.add(bakery);
                }
            }
            boolean bottledmilk=false;
            boolean icecream=false;
            for(int f= random.nextInt(10);f<5;f+=5)
            {
                bottledmilk=true;
                goals.put("bottledmilk", random.nextInt(10));
                MilkProcessing milkProcessing=new MilkProcessing();
                milkProcessing.level=1;
                facilityCycle.add(milkProcessing);
                for(int g= random.nextInt(10);g<5;g+=5)
                {
                    icecream=true;
                    goals.put("icecream", random.nextInt(10));
                    IceCreamFactory iceCreamFactory=new IceCreamFactory();
                    iceCreamFactory.level=1;
                    facilityCycle.add(iceCreamFactory);
                }
            }
            boolean fabric=false;
            boolean shirt=false;
            for(int f= random.nextInt(10);f<5;f+=5)
            {
                fabric=true;
                 FabricFactory fabricFactory=new FabricFactory();
                goals.put("fabric", random.nextInt(10));
                fabricFactory.level= 1;
                facilityCycle.add(fabricFactory);
                for(int g= random.nextInt(10);g<5;g+=5)
                {
                    shirt=true;
                    goals.put("shirt", random.nextInt(10));
                    SewingFactory sewingFactory=new SewingFactory();
                    sewingFactory.level= 1;
                    facilityCycle.add(sewingFactory);
                }
            }



if(!eggpowder) {
    for (int f = random.nextInt(10); f < 5; f += 5) {
        EggPowder eggPowder = new EggPowder();
        eggPowder.level = 0;
        facilityCycle.add(eggPowder);
        if(!bread) {
            for (int g = random.nextInt(10); g < 5; g += 5) {
                Bakery bakery = new Bakery();
                bakery.level = 0;
                facilityCycle.add(bakery);
            }
        }
    }
}
if(!bottledmilk) {
    for (int f = random.nextInt(10); f < 5; f += 5) {
        MilkProcessing milkProcessing = new MilkProcessing();
        milkProcessing.level = 0;
        facilityCycle.add(milkProcessing);
        if (!icecream) {
            for (int g = random.nextInt(10); g < 5; g += 5) {
                IceCreamFactory iceCreamFactory = new IceCreamFactory();
                iceCreamFactory.level = 0;
                facilityCycle.add(iceCreamFactory);
            }
        }
    }
}

if(!fabric) {
    for (int f = random.nextInt(10); f < 5; f += 5) {
        FabricFactory fabricFactory = new FabricFactory();
        fabricFactory.level = 0;
        facilityCycle.add(fabricFactory);
        if (!shirt) {
            for (int g = random.nextInt(10); g < 5; g += 5) {
                SewingFactory sewingFactory = new SewingFactory();
                sewingFactory.level = 0;
                facilityCycle.add(sewingFactory);
            }
        }
    }
}




            int numThreats=random.nextInt(boundThreats)+2;
            for(int k=0;k<numThreats;k++)
            {
                if(random.nextInt()%3==0)
                {
                    threats.put(random.nextInt(SGT),"bear");
                }
                else if(random.nextInt()%3==1)
                {
                    Tiger tiger=new Tiger();
                    threats.put( random.nextInt(SGT),"tiger");
                }
                else{
                    Lion lion=new Lion();
                    threats.put( random.nextInt(SGT),"lion");
                }
            }
            goals.put("money",random.nextInt(5000));
            goldStar*=random.nextInt(100)/40;
            goldStar+=50;
            silverStar=goldStar* random.nextInt(40)/40;
            silverStar-=5;
            brozeStar=silverStar*random.nextInt(40)/40;
            brozeStar-=10;
            Level level=new Level(i,SGT, SST,SBT,goldStar+10,silverStar+10,brozeStar+10,animalCycle,threats,facilityCycle,goals, 100+random.nextInt(200));
           levels.add(level);
        }
        try {
            String LevelArrayList = gson.toJson(levels);
            FileWriter levelArrayList = new FileWriter("LevelArrayList.json");
            levelArrayList.write(LevelArrayList);
            levelArrayList.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}