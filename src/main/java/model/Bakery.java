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
    public Bakery(int i, int j) {
        super(i, j);
        this.type="bakery";
        this.unitPriceTag=250;
        this.outputTimeout=150;
    }
    public Bakery()
    {
        super();
        this.type="bakery";
        this.unitPriceTag=250;
        this.outputTimeout=150;
    }
}
