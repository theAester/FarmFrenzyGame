package model;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
    public Storable queryItem(String name){
        Storable item = storedObjects.stream().filter(e->e.getName().toLowerCase().equals(name)).findFirst().orElse(null);
        storedObjects.remove(item);
        return item;
    }
    public ArrayList<Storable> queryItem(String name, int count){
        ArrayList<Storable> items = (ArrayList) storedObjects.stream().filter(e->e.getName().toLowerCase().equals(name)).collect(Collectors.toList());
        if(items.size() < count) return null;
        ArrayList<Storable> output = new ArrayList<>();
        for(int i=0;i<count;i++){
            Storable item = items.get(i);
            output.add(item);
            storedObjects.remove(item);
        }
        return output;
    }

    public boolean addAll(ArrayList<Storable> items) {
        int size =0;
        for (Storable item : items) {
            size += item.getStoringSize();
        }
        if(getAvailable() < size) return false;
        items.forEach(object ->{
            occupied += object.getStoringSize();
            storedObjects.add(object);
        });
        return true;
    }

    public Egg queryEgg() {
        return (Egg) storedObjects.stream().filter(x -> x.getName().equals("egg")).findFirst().orElse(null);
    }
}
