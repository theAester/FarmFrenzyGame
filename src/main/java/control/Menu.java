package control;
import view.Printer;

import java.util.ArrayList;
import java.util.HashMap;
public class Menu {
    private int levelAccomplished,star,coin;
    private String fullName;
    private HashMap<Levels,Integer> LevelMap;
    private ArrayList<Level> levelsList;
    private Level currentLevel;
    private User user;
    public Menu(User user) {
        this.user = user;
        this.levelAccomplished=user.g
    }
    public void Run()
    {
        Printer.Menu();
    }
}
