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
            Egg egg = levelManager.requestEgg();
            if (egg == null) {
                Printer.NotEnough("milk");
                return false;
            }
            this.productionCount = 1;
            this.outputSeq = 0;
            this.busy = true;
            return true;
        } else {
            Egg egg = levelManager.requestEgg();
            if (egg == null) {
                Printer.NotEnough("milk");
                return false;
            }
            Egg egg2 = levelManager.requestEgg();
            if (egg2 != null) {
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
        this.level++;
    }

    @Override
    public void collect() {

    }

    @Override
    public void produce(LevelManager levelManager) {
        levelManager.generatePowder();
        if(this.productionCount==2)
        {
            levelManager.generatePowder();
        }
    }

    public MilkProcessing(int i, int j) {
        super(i, j);
        this.type="milkprocessing";
        this.unitPriceTag=400;
        this.outputTimeout=180;
    }

    public MilkProcessing() {
        super();
        this.type="milkprocessing";
        this.unitPriceTag=400;
        this.outputTimeout=180;
    }
}
