package model;

import java.util.ArrayList;

public class Truck {
    public boolean isTraveling;
    public int travelSequence;
    public int travelInterval;
    public int carriedMoney;
    public int occupiedSpace;
    public int MAX_STORAGE;
    public int level;
    public int MAX_LEVEL;
    public ArrayList<Storable> objects;
    public Truck(){
        objects = new ArrayList<>();
        isTraveling = false;
        travelSequence = -1;
        travelInterval =90;
        carriedMoney = 0;
        occupiedSpace =0;
        MAX_STORAGE = 30;
        level = 1;
        MAX_LEVEL =2;
    }
    public boolean load(Storable object){
        if(isTraveling) return false;
        int size = object.getStoringSize();
        if(occupiedSpace + size > MAX_STORAGE) return false;
        carriedMoney += object.getUnitPrice();
        occupiedSpace += object.getStoringSize();
        objects.add(object);
        return true;
    }
    public boolean ride(){
        if(isTraveling) return false;
        isTraveling = true;
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
            travelSequence+=30;
            return 1;
        }else if(travelSequence == travelInterval){
            travelSequence = -1;
            isTraveling = false;
            return 2;
        }
        return 0;
    }
    public void reset(){
        objects = new ArrayList<Storable>();
        carriedMoney =0;
        occupiedSpace =0;
    }
    public boolean loadAll(ArrayList<Storable> items) {
        if(isTraveling) return false;
        int size=0;
        for (Storable item : items) {
            size += item.getStoringSize();
        }
        if(occupiedSpace + size > MAX_STORAGE) return false;
        items.forEach(object ->{
            carriedMoney += object.getUnitPrice();
            occupiedSpace += object.getStoringSize();
            objects.add(object);
        });
        return true;
    }

    public Storable queryItem(String name) {
        Storable item = objects.stream().filter(e->e.getName().toLowerCase().equals(name)).findFirst().orElse(null);
        objects.remove(item);
        return item;
    }
}
