package model;

import control.LevelManager;

public class IceCreamFactory extends Facility {
    public static long price;
    @Override
    public void update(LevelManager levelManager) {

    }

    @Override
    public void upgrade() {

    }

    @Override
    public void collect() {

    }

    @Override
    public void produce() {

    }

    public IceCreamFactory(int i, int j) {
        super(i, j);
        this.type="icecreamfactory";
        this.unitPriceTag=550;
        this.outputTimeout=210;
    }

    public IceCreamFactory() {
        super();
        this.type="icecreamfactory";
        this.unitPriceTag=550;
        this.outputTimeout=210;
    }
}
