package model;

import control.LevelManager;

public class EggPowder extends Facility {
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

    public EggPowder(int i, int j) {
        super(i, j);
        this.type="eggpowder";
        this.unitPriceTag=150;
        this.outputTimeout=120;
    }
    public EggPowder() {
        super();
        this.type="eggpowder";
        this.unitPriceTag=150;
        this.outputTimeout=120;
    }
}

