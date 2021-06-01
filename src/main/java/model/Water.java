package model;

public class Water {
    public int level;
    public int refilInterval;
    public int MAX_LEVEL;
    public int total;
    private int left;
    public boolean takeWater(){
        if(left != 0){
            left--;
            return true;
        }else return false;
    }public int reFill(){
        if(left < total){
            left = total;
            return refilInterval;
        }else return 0;
    }
    public boolean upgrade(){
        if(level<MAX_LEVEL){
            total += level;
            refilInterval -= 1; // TODO: fix value;
            return true;
        }return false;
    }
}
