package model;
import control.LevelManager;

import java.util.Random;
public abstract class Animal{
    public String type;
    protected int unitPriceTag;
    protected final int BoxWidth=1;
    protected final int BoxHeight=1;
    protected int idleSequence;
    protected int outputTimeout;
    protected int quota;
    protected int consumptionPortion;
    //consuption to health:C2H
    protected double C2H;
    //x y (offset) in graphics
    protected int x;
    protected int y;
    //i j in 6*6
    protected int i;
    protected int j;
    protected int step;
    protected int xNew;
    protected int yNew;
    protected int iNew;
    protected int jNew;
    protected int health;
    protected double v;
    protected int maxHealth=10;
    protected int productionRate;
    protected int productionPoint;
    protected boolean consume=false;
    public boolean alive=true;

    public void eat(LevelManager levelManager,int i,int j)
    {
        levelManager.grid[i][j]=levelManager.grid[i][j]-consumptionPortion;
    }
    public abstract void produce(LevelManager levelManager);
    public int getHealth(){
        return health;
    }
    public Animal(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public Animal()
    {
        Random ran = new Random();
        this.i=ran.nextInt(6);
        this.j=ran.nextInt(6);
    }
    public abstract void update(LevelManager levelManager);

    public int getCoordinateX(){
        //TODO: fix (graphic)
        return i;
    }
    public int getCoordinateY(){
        //TODO: fix (graphic)
        return j;
    }
}
