package control;
import view.Printer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LevelInputManager {
    LevelManager manager=new LevelManager();
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
    }
    public void inGame() throws IOException {
        String input="";
        while(inGame)
        {
            input=scanner.nextLine();
            input.toLowerCase();
            if(Check(input,"buy\\s[a-zA-Z]+"))
            {
                if(manager.CanBuyAnimal(Enum.valueOf(Split(input)[1])))
                {
                    //TODO
                    Printer.BuyAnimal(Enum.valueOf(Split(input)[1]));
                    LogAppender.BuyAnimal(Split(input)[1],0,0);
                }
                else{
                    //TODO
                    Printer.NotEnoughMoney();
                    LogAppender.NotEnoughmoney();
                }
            }
            else if(Check(input,"pickup\\s[0-9]+\\s[0-9]+")){
                if(manager.canPickup(Integer.parseInt(Split(input)[1]),Integer.parseInt(Split(input)[2])))
                {
                    Printer.Pickup(Integer.parseInt(Split(input)[1]),Integer.parseInt(Split(input)[2]));
                    LogAppender.Pickup(Integer.parseInt(Split(input)[1]),Integer.parseInt(Split(input)[2]));
                }
                else
                {
                    Printer.NullPoint();
                    LogAppender.NullPoint();
                }
            }
            else if(Check(input,"well"))
            {

            }
            else if(Check(input,"plant\\s[0-9]+\\s[0-9]+"))
            {

            }
            else if(Check(input,"work\\s[a-z]+"))
            {

            }
            else if(Check(input,"cage\\s[0-9]+\\s[0-9]+"))
            {

            }
            else if(Check(input,"turn\\s[0-9]+"))
            {

            }
            else if(Check(input,"truck\\sload\\s[a-z]+"))
            {

            }
            else if(Check(input,"truck\\sunload\\s[a-z]+"))
            {

            }
            else if(Check(input,"truck\\sgo"))
            {

            }

        }
    }
    //utility methods
    private boolean Check(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
    private String[] Split(String string) {
        return string.split("\\s");
    }
}
