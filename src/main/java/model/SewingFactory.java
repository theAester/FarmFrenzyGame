package model;

import control.LevelManager;

public class SewingFactory extends Facility {
    //khayyati
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

    public SewingFactory(int i, int j) {
        super(i, j);
        this.type="sewingfactory";
        this.unitPriceTag=400;
        this.outputTimeout=180;
    }

    public SewingFactory() {
        super();
        this.type="sewingfactory";
        this.unitPriceTag=400;
        this.outputTimeout=180;
    }
}
