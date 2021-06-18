package model;
import control.LevelManager;
public class Egg extends Commodity {

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
    public Egg(int i, int j) {
        super(i, j);
        this.type="egg";
        this.storingSize=1;
        this.unitPriceTag=15;
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
