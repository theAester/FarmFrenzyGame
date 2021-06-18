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
    protected int x;
    protected int y;
    protected int i;
    protected int j;
    protected int xNew;
    protected int yNew;
    protected int iNew;
    protected int jNew;
    protected int health;
    protected double v;
    protected int storingSize;
    protected int unitPriceTag;

    public abstract void update();
    public abstract void attack();
    public Threat(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public Threat()
    {
        Random ran = new Random();
        this.i=ran.nextInt(6);
        this.i++;
        this.j=ran.nextInt(6);
        this.j++;
    }

    public boolean inside(int x, int y){
        return true;
    }

    public void cage(){
        quota++;
    }
}
