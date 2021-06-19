package control;

import model.Animal;
import model.Facility;
import model.Threat;

import java.util.ArrayList;
import java.util.HashMap;

public class Level {
    private int level,goldTime,silverTime,bronzeTime,goldStars,silverStars,bronzeStars,initialBalance;
    private ArrayList<Animal> AnimalCycle;
    private ArrayList<Facility> FacilityCycle;
    private HashMap<String ,Integer> ThreatCycle;
    private HashMap<String,Integer> LevelGoals;
    // All data of a level should be here

    public Level(int level, int goldTime, int silverTime, int bronzeTime, int goldStars, int silverStars, int bronzeStars,ArrayList animalCycle,HashMap threatCycle,ArrayList facilityCycle,HashMap levelGoals,int initialBalance) {
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
        this.initialBalance=initialBalance;
    }

    public int getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(int initialBalance) {
        this.initialBalance = initialBalance;
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


    public ArrayList<Animal> getAnimalCycle() {
        return AnimalCycle;
    }

    public void setAnimalCycle(ArrayList<Animal> animalCycle) {
        AnimalCycle = animalCycle;
    }

    public ArrayList<Facility> getFacilityCycle() {
        return FacilityCycle;
    }

    public void setFacilityCycle(ArrayList<Facility> facilityCycle) {
        FacilityCycle = facilityCycle;
    }

    public HashMap<String,Integer> getThreatCycle() {
        return ThreatCycle;
    }

    public void setThreatCycle(HashMap<String ,Integer> threatCycle) {
        ThreatCycle = threatCycle;
    }

    public HashMap<String, Integer> getLevelGoals() {
        return LevelGoals;
    }

    public void setLevelGoals(HashMap<String, Integer> levelGoals) {
        LevelGoals = levelGoals;
    }
}
