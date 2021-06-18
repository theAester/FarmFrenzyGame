package model;
import control.*;
class Bakery extends Facility {
    public static long price;

    @Override
    public void update(LevelManager levelManager) {

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
