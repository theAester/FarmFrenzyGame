package model;

public class SewingFactory extends Facility {
    public static long price;
    @Override
    public void update() {

    }

    @Override
    public void upgrade() {
        this.level++;
    }

    @Override
    public void collect() {

    }

    @Override
    public void produce() {

    }

    public SewingFactory(int x, int y) {
        super(x, y);
    }

    public SewingFactory() {
        super();
    }
}
