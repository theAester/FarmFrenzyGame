package model;

import java.util.ArrayList;

public class Storage {
    public int level;
    public int MAX_LEVEL;
    public ArrayList<Storable> storedObjects;
    public int MAX_STORAGE;
    public int occupied;
    public int getAvailable(){
        return MAX_STORAGE - occupied;
    }
    public boolean upgrade(){
        if(level < MAX_LEVEL){
            MAX_STORAGE += (level+1)*(7-level);
            level++;
            return true;
        }else return false;
    }
    public boolean add(Storable object){
        int size = object.getStoringSize();
        if(getAvailable() >= size){
            occupied += size;
            storedObjects.add(object);
            return true;
        }else return false;
    }
}
