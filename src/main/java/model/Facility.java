package model;

import control.LevelManager;

public abstract class Facility {
protected String type;
protected int x;
protected int y;
protected int i;
protected int j;
protected int level=1;
protected int outputSeq;
protected int outputTimeout;
protected boolean produced;
protected boolean isReady=true;
protected boolean busy=false;
protected int unitPriceTag;
protected int productionCount;

    public abstract void upgrade();
    public abstract void collect();
    public abstract void produce(LevelManager levelManager);
    public abstract boolean work(LevelManager levelManager);
    public Facility(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public String getType(){
        return type;
    }
    public Facility() {
    }
    public int getCoordinateX(){
        //TODO: fix (graphic)
        return i;
    }

    public int getCoordinateY(){
        //TODO: fix (graphic)
        return j;
    }

    public abstract int update(LevelManager levelManager);
}
