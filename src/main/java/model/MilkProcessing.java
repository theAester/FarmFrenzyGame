package model;

import control.LevelManager;

public class MilkProcessing extends Facility {
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

    public MilkProcessing(int i, int j) {
        super(i, j);
        this.type="milkprocessing";
        this.unitPriceTag=400;
        this.outputTimeout=180;
    }

    public MilkProcessing() {
        super();
        this.type="milkprocessing";
        this.unitPriceTag=400;
        this.outputTimeout=180;
    }
}
