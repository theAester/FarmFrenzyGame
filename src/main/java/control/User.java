package control;
import java.util.HashMap;
public class User {
    private String firstName,lastName,password;
    private int star;
    private long coin;
    private int levelAccomplished;
    private HashMap<ENUM,Integer> LevelMap;
    private boolean isVoid;
    public User(String firstName, String lastName, String password, int star, long coin, int levelAccomplished, HashMap<ENUM, Integer> LevelMap, boolean isVoid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.star = star;
        this.coin = coin;
        this.levelAccomplished = levelAccomplished;
        this.LevelMap = LevelMap;
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

    public HashMap<ENUM, Integer> getLevelMap() {
        return LevelMap;
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


    public void setLevelMap(HashMap<ENUM, Integer> LevelMap) {
        this.LevelMap = LevelMap;
    }

    public void setVoid(boolean aVoid) {
        isVoid = aVoid;
    }
}
