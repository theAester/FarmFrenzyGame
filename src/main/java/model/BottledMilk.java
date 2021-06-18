package model;
import control.LevelManager;
public class BottledMilk extends Commodity {

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
    public BottledMilk(int i, int j) {
        super(i, j);
        this.type="bottledmilk";
        this.storingSize=2;
        this.unitPriceTag=60;
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



