package model;

import control.LevelManager;
import view.Printer;

public class IceCreamFactory extends Facility {
    /**
     *<h3>update function</h3>
     * update status library:<br>
     * 0 = idle: no action<br>
     * 1 = is processing<br>
     * 2 = done<br>
     * @return update status
     */
    @Override
    public int update(LevelManager levelManager) {
        if( outputSeq != outputTimeout && outputSeq != -1){
            outputSeq++;
            return 1;
        }else if(outputSeq == outputTimeout){
            outputSeq = -1;
            busy = false;
            produce(levelManager);
            return 2;
        }
        return 0;
    }

    @Override
    public boolean work(LevelManager levelManager) {
        if (this.level == 1) {
            BottledMilk bottledMilk = levelManager.requestBottledMilk();
            if (bottledMilk == null) {
                Printer.NotEnough("bottledmilk");
                return false;
            }
            this.productionCount = 1;
            this.outputSeq = 0;
            this.busy = true;
            return true;
        } else {
            BottledMilk bottledMilk = levelManager.requestBottledMilk();
            if (bottledMilk == null) {
                Printer.NotEnough("bottledmilk");
                return false;
            }
            BottledMilk bottledMilk2 = levelManager.requestBottledMilk();
            if (bottledMilk2 != null) {
                this.productionCount = 2;
            } else {
                this.productionCount = 1;
            }
            this.outputSeq = 0;
            this.busy = true;
            return true;
        }
    }

    @Override
    public void upgrade() {

    }

    @Override
    public void collect() {

    }

    @Override
    public void produce(LevelManager levelManager) {
        levelManager.generateIceCream(getCoordinateX(),getCoordinateY());
        if(this.productionCount==2)
        {
            levelManager.generateIceCream(getCoordinateX(),getCoordinateY());
        }
    }

    public IceCreamFactory(int i, int j) {
        super(i, j);
        this.type="icecreamfactory";
        this.unitPriceTag=550;
        this.outputTimeout=210;
    }

    public IceCreamFactory() {
        super();
        this.type="icecreamfactory";
        this.unitPriceTag=550;
        this.outputTimeout=210;
    }
}
