package control;
import view.Printer;

import java.io.IOException;
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
    private Level currentLevel;
    private Scanner scanner=new Scanner(System.in);
    public LevelInputManager(User thisUser, int levelAccomplished, int star, long coin, String fullName, HashMap<String, Integer> levelMap, Level currentLevel) {
        this.thisUser = thisUser;
        this.levelAccomplished = levelAccomplished;
        this.star = star;
        this.coin = coin;
        this.fullName = fullName;
        LevelMap = levelMap;
        this.currentLevel = currentLevel;
        inGame();
        Save save=new Save();
        save.GenerateLevel(10,100,100,100,100,1001,100,5,5);
    }
    public void inGame() {
        LevelManager LM=new LevelManager(currentLevel);
    }

}
