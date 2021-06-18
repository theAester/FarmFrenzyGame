package control;

import model.Animal;
import model.Facility;
import model.Threat;

import java.util.ArrayList;
import java.util.HashMap;

public class Level {
    private int level,goldTime,silverTime,bronzeTime,goldStars,silverStars,bronzeStars;
    private ArrayList<Animal> AnimalCycle;
    private ArrayList<Facility> FacilityCycle;
    private HashMap<Integer, Enum> ThreatCycle;
    private HashMap<Enum,Integer> LevelGoals;
    // All data of a level should be here

    public Level(int level, int goldTime, int silverTime, int bronzeTime, int goldStars, int silverStars, int bronzeStars,ArrayList animalCycle,HashMap threatCycle,ArrayList facilityCycle,HashMap levelGoals) {
        this.level = level;
        this.goldTime = goldTime;
        this.silverTime = silverTime;
        this.bronzeTime = bronzeTime;
        this.goldStars = goldStars;
        this.silverStars = silverStars;
        this.bronzeStars = bronzeStars;
        this.AnimalCycle=animalCycle;
        this.ThreatCycle=threatCycle;
        this.FacilityCycle=facilityCycle;
        this.LevelGoals=levelGoals;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGoldTime() {
        return goldTime;
    }

    public void setGoldTime(int goldTime) {
        this.goldTime = goldTime;
    }

    public int getSilverTime() {
        return silverTime;
    }

    public void setSilverTime(int silverTime) {
        this.silverTime = silverTime;
    }

    public int getBronzeTime() {
        return bronzeTime;
    }

    public void setBronzeTime(int bronzeTime) {
        this.bronzeTime = bronzeTime;
    }

    public int getGoldStars() {
        return goldStars;
    }

    public void setGoldStars(int goldStars) {
        this.goldStars = goldStars;
    }

    public int getSilverStars() {
        return silverStars;
    }

    public void setSilverStars(int silverStars) {
        this.silverStars = silverStars;
    }

    public int getBronzeStars() {
        return bronzeStars;
    }

    public void setBronzeStars(int bronzeStars) {
        this.bronzeStars = bronzeStars;
    }





    public HashMap<Enum, Integer> getLevelGoals() {
        return LevelGoals;
    }

    public void setLevelGoals(HashMap<Enum, Integer> levelGoals) {
        LevelGoals = levelGoals;
    }
}
