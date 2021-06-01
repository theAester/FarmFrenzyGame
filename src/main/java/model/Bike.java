package model;

import java.util.ArrayList;

public class Bike {
    public boolean isTraveling;
    public int travelSequence;
    public int travelInterval;
    public int carriedMoney;
    public int storageSpace;
    public int MAX_STORAGE;
    public int level;
    public int MAX_LEVEL;
    public ArrayList<Storable> objects;
    public boolean load(Storable object){
        if(isTraveling) return false;
        int size = object.getStoringSize();
        if(storageSpace + size > MAX_STORAGE) return false;
        carriedMoney += object.getUnitPrice();
        storageSpace = object.getUnitPrice();
        objects.add(object);
        return true;
    }
    public boolean ride(){
        if(isTraveling) return false;
        travelSequence = 0;
        return true;
    }
    public boolean upgrade(){
        if(level != MAX_LEVEL) return false;
        travelSequence -= level; // TODO: correct value;
        return true;
    }
    /**
     *<h3>update function</h3>
     * update status library:<br>
     * 0 = idle: no action<br>
     * 1 = is travelling<br>
     * 2 = returned<br>
     * @return update status
     */
    public int update(){
        if( travelSequence != travelInterval && travelSequence != -1){
            travelSequence++;
            return 1;
        }else if(travelSequence == travelInterval){
            travelSequence = -1;
            return 2;
        }
        return 0;
    }
}
