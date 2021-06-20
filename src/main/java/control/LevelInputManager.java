package control;
import view.Printer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LevelInputManager {
    private boolean inGame=true;
    private User thisUser;
    private int levelAccomplished,star;
    private long coin;
    private String fullName;
    private HashMap<String,Integer> LevelMap;
    private ArrayList<User> userArrayList=new ArrayList<>();
    private Level currentLevel;
    private Scanner scanner=new Scanner(System.in);
    public LevelInputManager(User thisUser, int levelAccomplished, int star, long coin, String fullName, HashMap<String, Integer> levelMap, Level currentLevel,ArrayList<User> userArrayList) {
        this.thisUser = thisUser;
        this.levelAccomplished = levelAccomplished;
        this.star = star;
        this.coin = coin;
        this.fullName = fullName;
        LevelMap = levelMap;
        this.currentLevel = currentLevel;
        this.userArrayList=userArrayList;
        inGame();
        Save save=new Save();
        //save.GenerateLevel(100,600,900,1200,200,150,100,10,10);
    }
    public void inGame() {
        LevelManager LM=new LevelManager(currentLevel);
        //System.out.println("Level Starts");
        LM.run();
        //out of the level
        int stars=0;
        int GoldStars=currentLevel.getGoldStars();
        int SilverStars=currentLevel.getSilverStars();
        int BronzeStars=currentLevel.getBronzeStars();
        System.out.println(currentLevel.getGoldTime());
        System.out.println(LM.cycleNumber);
        if(LM.cycleNumber<=currentLevel.getGoldTime())
        {
            stars=GoldStars;
        }
       else  if(LM.cycleNumber<=currentLevel.getSilverTime())
        {
            stars=SilverStars;
        }
       else
        {
            stars=BronzeStars;
        }
        Printer.LevelDone(currentLevel.getLevel(),stars,LM.cycleNumber);
        thisUser.setStar(thisUser.getStar()+stars);
        Printer.ShowStars(thisUser.getStar());
        for(User i:userArrayList)
        {
            if(i.getFirstName()+i.getLastName()==fullName)
            {
                if(i.getLevelAccomplished()==currentLevel.getLevel()-1){
                i.setLevelAccomplished(i.getLevelAccomplished()+1);}
                i.setStar(thisUser.getStar());
            }
        }
        Save.UserList(userArrayList);
    }

}
