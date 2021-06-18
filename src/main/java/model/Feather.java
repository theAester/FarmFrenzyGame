package model;
import control.LevelManager;
public class Feather extends Commodity {

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
    public Feather(int i, int j) {
        super(i, j);
        this.type="feather";
        this.storingSize=1;
        this.unitPriceTag=20;
        this.outputTimeout=120;
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

