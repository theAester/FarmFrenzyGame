package model;

import control.LevelManager;
import view.Printer;

public class EggPowder extends Facility {
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
            Egg egg = levelManager.requestEgg();
            if (egg == null) {
                Printer.NotEnough("egg");
                return false;
            }
            this.productionCount = 1;
            this.outputSeq = 0;
            this.busy = true;
            this.scale=1;
            return true;
        } else if(level == 2) {
            Egg egg = levelManager.requestEgg();
            if (egg == null) {
                Printer.NotEnough("egg");
                return false;
            }
            Egg egg2 = levelManager.requestEgg();
            if (egg2 != null) {
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
    public String getType() {
        return this.type;
    }

    @Override
    public void collect() {

    }

    @Override
    public void produce(LevelManager levelManager) {
        levelManager.generatePowder(getCoordinateX(),getCoordinateY());
        if(this.productionCount==2)
        {
        levelManager.generatePowder(getCoordinateX(),getCoordinateY());
        }
    }

    public EggPowder(int i, int j) {
        super(i, j);
        this.type = "eggpowder";
        this.unitPriceTag = 150;
        this.outputTimeout = 90;
        this.upgradeFee=350;
    }

    public EggPowder() {
        super();
        this.type = "eggpowder";
        this.unitPriceTag = 150;
        this.outputTimeout = 90;
        this.upgradeFee=350;
    }
}

