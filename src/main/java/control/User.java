package control;
import java.util.HashMap;
public class User {
    private String firstName,lastName,password;
    private int star;
    private long coin;
    private int levelAccomplished;
    private HashMap<Levels,Integer> factoryLevelMap;
    private HashMap<Levels,Integer> animalsLevelMap;
    private boolean isVoid;
    public User(String firstName, String lastName, String password, int star, long coin, int levelAccomplished, HashMap<Levels, Integer> factoryLevelMap, HashMap<Levels, Integer> animalsLevelMap,boolean isVoid) {
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

    public int getStar() {
        return star;
    }

    public long getCoin() {
        return coin;
    }

    public int getLevelAccomplished() {
        return levelAccomplished;
    }

    public HashMap<Levels, Integer> getFactoryLevelMap() {
        return factoryLevelMap;
    }

    public HashMap<Levels, Integer> getAnimalsLevelMap() {
        return animalsLevelMap;
    }

    public boolean isVoid() {
        return isVoid;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public void setCoin(long coin) {
        this.coin = coin;
    }

    public void setLevelAccomplished(int levelAccomplished) {
        this.levelAccomplished = levelAccomplished;
    }

    public void setFactoryLevelMap(HashMap<Levels, Integer> factoryLevelMap) {
        this.factoryLevelMap = factoryLevelMap;
    }

    public void setAnimalsLevelMap(HashMap<Levels, Integer> animalsLevelMap) {
        this.animalsLevelMap = animalsLevelMap;
    }

    public void setVoid(boolean aVoid) {
        isVoid = aVoid;
    }
}
