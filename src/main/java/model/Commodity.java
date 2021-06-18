package model;

public abstract class Commodity {
    protected String type;
    protected long price;
    protected int x;
    protected int y;

    public abstract void acquire();
}
