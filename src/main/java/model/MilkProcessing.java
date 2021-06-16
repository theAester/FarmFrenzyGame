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

    public MilkProcessing(int x, int y) {
        super(x, y);
    }

    public MilkProcessing() {
        super();
    }
}
