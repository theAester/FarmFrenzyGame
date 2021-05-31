package control;
import java.util.HashMap;
public class User {
    private String firstName,lastName,password;
    private long star,coin;
    private int levelAccomplished;
    private HashMap<Levels,Integer> factoryLevelMap;
    private HashMap<Levels,Integer> animalsLevelMap;
    private boolean isVoid;
    public User(String firstName, String lastName, String password, long star, long coin, int levelAccomplished, HashMap<Levels, Integer> factoryLevelMap, HashMap<Levels, Integer> animalsLevelMap,boolean isVoid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.star = star;
        this.coin = coin;
        this.levelAccomplished = levelAccomplished;
        this.factoryLevelMap = factoryLevelMap;
        this.animalsLevelMap = animalsLevelMap;
        this.isVoid=isVoid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }
}
