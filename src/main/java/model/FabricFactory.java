package model;

import control.LevelManager;

public class FabricFactory extends Facility {
    //parche bafi
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

    public FabricFactory(int i, int j) {
        super(i, j);
        this.type="fabricfactory";
        this.unitPriceTag=250;
        this.outputTimeout=150;
    }

    public FabricFactory() {
        super();
        this.type="fabricfactory";
        this.unitPriceTag=250;
        this.outputTimeout=150;
    }
}
