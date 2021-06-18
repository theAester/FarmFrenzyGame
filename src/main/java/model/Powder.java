package model;
import control.LevelManager;
public class Powder extends Commodity {

    @Override
    public void acquire() {

    }
    @Override
    public int getStoringSize(){
        return storingSize;
    }

    @Override
    public int getUnitPrice() {
        return unitPriceTag;
    }
    public Powder(int i, int j) {
        super(i, j);
        this.type="powder";
        this.storingSize=2;
        this.unitPriceTag=40;
        this.outputTimeout=150;
    }

    @Override
    public int getI() {
        return this.i;
    }

    @Override
    public int getJ() {
        return this.j;
    }

    @Override
    public String getName() {
        return this.type;
    }
}


