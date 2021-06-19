package model;
import control.LevelManager;

import java.util.Random;

public abstract class Threat implements Storable{
    public String type;
    protected final int BoxWidth=1;
    protected final int BoxHeight=1;
    protected int idleSequence;
    protected int outputTimeout;
    protected int quota;
    protected int clicks;
    protected int x;
    protected int y;
    protected int i;
    protected int j;
    protected int xNew;
    protected int yNew;
    protected int iNew;
    protected int jNew;
    public boolean alive;
    protected double v;
    protected int storingSize;
    protected int unitPriceTag;
    protected int criticalSequence;

    public abstract void update(LevelManager levelManager);
    public abstract void attack();
    public Threat(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public Threat()
    {
        Random ran = new Random();
        alive = true;
        criticalSequence = -1;
        this.i=ran.nextInt(6);
        this.i++;
        this.j=ran.nextInt(6);
        this.j++;
    }


    public boolean inside(int x, int y){
        return x==i && y==j;
    }

    public void cage(int cycleNumber){
        clicks++;
        criticalSequence = cycleNumber;
    }

    public int getI(){
        return i;
    }
    public int getJ(){
        return j;
    }

    public int getRemainingClicks() {
        return quota-clicks;
    }

    public int getCoordinateX(){
        //TODO -graphic-> fix;
        return i;
    }
    public int getCoordinateY(){
        //TODO -graphic-> fix;
        return j;
    }
}
