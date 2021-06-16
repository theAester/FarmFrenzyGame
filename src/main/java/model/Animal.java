package model;
import control.LevelManager;

import java.util.Random;
public abstract class Animal {
    public String type;
    protected final int BoxWidth=1;
    protected final int BoxHeight=1;
    protected int idleSequence;
    protected int outputTimeout;
    protected int quota;
    protected int consumptionPortion;
    protected double C2H;
    protected int x;
    protected int y;
    protected int i;
    protected int j;
    protected int step;
    protected int xNew;
    protected int yNew;
    protected int iNew;
    protected int jNew;
    protected int health;
    protected double v;
    protected int maxHealth;
    protected int productionRate;
    protected int productionPoint;
    protected boolean consume=false;

    public abstract void produce();

    public Animal(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Animal()
    {
        Random ran = new Random();
        this.x=ran.nextInt(6);
        //this.x++;
        this.y=ran.nextInt(6);
        //this.y++;
    }

    public abstract void update(LevelManager levelManager);
}
