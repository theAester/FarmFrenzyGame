package model;

public abstract class Commodity implements Storable {
    protected String type;
    protected long price;
    protected int x;
    protected int y;

    public abstract void acquire();

    public abstract int getI();

    public abstract int getJ();

    public abstract String getName();
}
