package control;

import view.Printer;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    private int levelAccomplished,star,coin;
    private String fullName;
    private HashMap<Levels,Integer> factoryLevelMap;
    private HashMap<Levels,Integer> animalsLevelMap;
    private ArrayList<Level> levelsList;
    private Level currentLevel;
    private User user;

    public Menu(User user) {
        this.user = user;
    }
    public void Run()
    {
        Printer.Menu();
    }
}
