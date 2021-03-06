package control;
import view.Authenticator;
import view.Printer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    private ArrayList<User> userArrayList=new ArrayList<>();
    private String fullName;
    private HashMap<String,Integer> LevelMap;
    private ArrayList<Level> levelsList;
    private Level currentLevel;
    private User user;
    Scanner scanner= new Scanner(System.in);
    public Menu(User user,ArrayList<User> userArrayList) throws FileNotFoundException {
        this.user = user;
        this.fullName=user.getFirstName()+user.getLastName();
        this.LevelMap=user.getLevelMap();
        this.levelsList=Load.LevelList();
        this.userArrayList=userArrayList;
    }
    public void Run() throws IOException {
        String input = "";
        Printer.Menu();
        while(!input.equalsIgnoreCase("exit"))
        {
            input=scanner.nextLine().toLowerCase();
            if(Check(input,"start\\s[0-9]+"))
            {
                //Check user access to this level
                if(user.getLevelAccomplished()+1>=Integer.parseInt(Split(input)[1])) {
                    Printer.StartLevel(Integer.parseInt(Split(input)[1]));
                    LevelInputManager im=new LevelInputManager(user, user.getLevelAccomplished(), user.getStar(), user.getCoin(), fullName, user.getLevelMap(),FindLevel(Integer.parseInt(Split(input)[1])),userArrayList );
                    userArrayList=Load.UserList();
                }
                else {
                    Printer.AccessDenied(Integer.parseInt(Split(input)[1]));
                }
            }
            else if(Check(input,"log\\sout"))
            {
                Printer.LoggedOut();
                LogAppender.Logout(fullName);
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
                    LogAppender.WrongInput(input);
                }
            }
        }
    }
    //Settings
    private void Settings()
    {
        String input="";
        Printer.Settings();
        while(!input.equalsIgnoreCase("exit")) {
            input = scanner.nextLine();
            if (Check(input, "help")) {
                Printer.HelpSettings();
            }
            if (Check(input, "unlock\\s[a-zA-Z]+")) {
                for (Map.Entry<String, Integer> entry : user.getLevelMap().entrySet()) {
                  //  System.out.println(entry.getKey());
                    //System.out.println();
                    if (entry.getKey().equals(Split(input)[1])) {
                        if (user.getStar() >= 100) {
                            entry.setValue(entry.getValue() + 1);
                            user.setStar(user.getStar()-100);
                            Printer.RemainingStars(user.getStar());
                            Printer.SuccessfullyUpgraded(entry.getValue());
                            for (User i:userArrayList)
                            {
                                if((i.getFirstName()+i.getLastName()).equals(user.getFirstName()+user.getLastName()))
                                {
                                    i.setStar(user.getStar());
                                    i.setLevelMap(user.getLevelMap());
                                }
                            }
                            Save.UserList(userArrayList);
                            userArrayList = Load.UserList();
                        } else {
                            Printer.NotEnough("star");
                        }
                    }
                }
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
        private Level FindLevel(int level) throws IOException {
            Level level1=null;
            for(Level i:levelsList)
            {
                if(i.getLevel()==level)
                {
                    level1=i;
                }
            }
            if(level1==null)
            {
                Printer.LevelNotFound(level);
                LogAppender.LevelNotFound(level);
            }
            return level1;
        }
}
