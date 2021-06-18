package model;
import control.LevelManager;
public class Bread extends Commodity {

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
    public Bread(int i, int j) {
        super(i, j);
        this.type="bread";
        this.storingSize=4;
        this.unitPriceTag=80;
        this.outputTimeout=180;
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


