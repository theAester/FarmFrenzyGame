package model;
import java.util.Random;

public abstract class Threat implements Storable{
    public String type;
    protected final int BoxWidth=1;
    protected final int BoxHeight=1;
    protected int idleSequence;
    protected int outputTimeout;
    protected int quota;
    protected int clicks;
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
    protected int storingSize;
    protected int unitPriceTag;

    public abstract void update();
    public abstract void attack();
    public Threat(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Threat()
    {
        Random ran = new Random();
        this.x=ran.nextInt(6);
        this.x++;
        this.y=ran.nextInt(6);
        this.y++;
        //System.out.println(this.x+"   "+this.y);
    }

    public boolean inside(int x, int y){
        return true;
    }

    public void cage(){
        quota++;
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
