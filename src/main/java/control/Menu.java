package control;
import view.Authenticator;
import view.Printer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    private int levelAccomplished,star;
    private long coin;
    private String fullName;
    private HashMap<ENUM,Integer> LevelMap;
    private ArrayList<Level> levelsList;
    private Level currentLevel;
    private User user;
    Scanner scanner= new Scanner(System.in);
    public Menu(User user) {
        this.user = user;
        this.levelAccomplished=user.getLevelAccomplished();
        this.star=user.getStar();
        this.coin=user.getCoin();
        this.fullName=user.getFirstName()+user.getLastName();
        this.LevelMap=user.getLevelMap();
    }
    public void Run() throws IOException {
        String input = "";
        Printer.Menu();
        while(!input.equalsIgnoreCase("exit"))
        {
            input=scanner.nextLine().toLowerCase();
            if(Check(input,"start//s[0-9]+"))
            {
                //Check user access to this level
                if(levelAccomplished+1>=Integer.parseInt(Split(input)[1])) {
                    Printer.StartLevel(Integer.parseInt(Split(input)[1]));
                }
                else {
                    Printer.AccessDenied(Integer.parseInt(Split(input)[1]));
                }
            }
            else if(Check(input,"log out"))
            {
                Printer.LoggedOut();
                Authenticator authenticator=new Authenticator();
                authenticator.Do();
                break;
            }
            else if(Check(input,"settings"))
            {
                Settings();
            }
            else{
                if(!input.equals(""))
                {
                    Printer.WrongInput();
                }
            }
        }
    }
    //Settings
    private void Settings()
    {
        String input="";
        Printer.Settings();
        while(!input.equalsIgnoreCase("exit"))
        {
            input=scanner.nextLine();
            if(Check(input,"help"))
            {
                Printer.HelpSettings();
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
