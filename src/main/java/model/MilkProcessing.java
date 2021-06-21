package model;

import control.LevelManager;
import view.Printer;

public class MilkProcessing extends Facility {
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
        if( this.outputSeq*this.scale != this.outputTimeout && this.outputSeq != -30){
            this.outputSeq+=30;
            return 1;
        }else if(this.outputSeq*this.scale == this.outputTimeout){
            this.outputSeq = -30;
            this.busy = false;
            produce(levelManager);
            return 2;
        }
        return 0;
    }

    @Override
    public boolean work(LevelManager levelManager) {
        if (this.level == 1) {
            Milk milk = levelManager.requestMilk();
            if (milk == null) {
                Printer.NotEnough("milk");
                return false;
            }
            this.productionCount = 1;
            this.outputSeq = 0;
            this.busy = true;
            this.scale=1;
            return true;
        } else if(level == 2) {
            Milk milk = levelManager.requestMilk();
            if (milk == null) {
                Printer.NotEnough("milk");
                return false;
            }
            Milk milk2 = levelManager.requestMilk();
            if (milk2 != null) {
                this.productionCount = 2;
                this.scale=1;
            } else {
                this.productionCount = 1;
                this.scale=2;
            }
            this.outputSeq = 0;
            this.busy = true;
            return true;
        }
        else{
            Printer.HaventBought();
            return false;
        }
    }

    @Override
    public void collect() {

    }

    @Override
    public void produce(LevelManager levelManager) {
        levelManager.generateBottledMilk(getCoordinateX(),getCoordinateY());
        if(this.productionCount==2)
        {
            levelManager.generateBottledMilk(getCoordinateX(),getCoordinateY());
        }
    }

    public MilkProcessing(int i, int j) {
        super(i, j);
        this.type="milkprocessing";
        this.unitPriceTag=400;
        this.outputTimeout=150;
        this.upgradeFee=400;
    }

    public MilkProcessing() {
        super();
        this.type="milkprocessing";
        this.unitPriceTag=400;
        this.outputTimeout=150;
        this.upgradeFee=400;
    }
}
