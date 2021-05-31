package model;
import control.*;
class Bakery extends Facility {
    public static int price;

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

    public Bakery(int x, int y) {
        super(x, y);
    }
    public Bakery()
    {
        super();
    }
}
