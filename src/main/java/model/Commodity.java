package model;

public abstract class Commodity implements Storable {
    protected String type;
    protected int x;
    protected int y;
    protected int i;
    protected int j;
    protected int storingSize;
    protected int unitPriceTag;
    protected int outputTimeout;

    public abstract void acquire();

    public Commodity(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public abstract int getI();

    public abstract int getJ();

    public abstract String getName();
    public int getCoordinateX(){
        //TODO:fix (graphic)
        return i;
    }
    public int getCoordinateY(){
        //TODO:fix (graphic)
        return j;
    }
}
