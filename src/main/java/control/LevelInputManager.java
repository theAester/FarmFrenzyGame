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
    private HashMap<Enum,Integer> LevelMap;
    private Level currentLevel;
    private Scanner scanner=new Scanner(System.in);
    public LevelInputManager(User thisUser, int levelAccomplished, int star, long coin, String fullName, HashMap<Enum, Integer> levelMap, Level currentLevel) {
        this.thisUser = thisUser;
        this.levelAccomplished = levelAccomplished;
        this.star = star;
        this.coin = coin;
        this.fullName = fullName;
        LevelMap = levelMap;
        this.currentLevel = currentLevel;
        inGame();
    }
    public void inGame() {
        LevelManager LM=new LevelManager(currentLevel);
    }

}
