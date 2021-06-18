package model;
import control.LevelManager;
public class Shirt extends Commodity {

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
    public Shirt(int i, int j) {
        super(i, j);
        this.type="shirt";
        this.storingSize=4;
        this.unitPriceTag=100;
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


