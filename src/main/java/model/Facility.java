package model;

public abstract class Facility {
protected String type;
protected int x;
protected int y;
protected int level=1;
protected int outputSeq;
protected int outputTimeout;
protected boolean produced;
protected boolean isReady=true;
protected boolean busy=false;

    public abstract void update();
    public abstract void upgrade();
    public abstract void collect();
    public abstract void produce();

    public Facility(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Facility() {
    }
}
