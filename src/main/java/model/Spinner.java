package model;

public class Spinner extends Facility {
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

    public Spinner(int x, int y) {
        super(x, y);
    }

    public Spinner() {
        super();
    }
}
