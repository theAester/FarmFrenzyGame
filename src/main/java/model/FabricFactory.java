package model;

import control.LevelManager;
import view.Printer;

public class FabricFactory extends Facility {
    //parche bafi
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
            Feather feather = levelManager.requestFeather();
            if (feather == null) {
                Printer.NotEnough("feather");
                return false;
            }
            this.productionCount = 1;
            this.outputSeq = 0;
            this.busy = true;
            this.scale=1;
            return true;
        } else {
            Feather feather = levelManager.requestFeather();
            if (feather == null) {
                Printer.NotEnough("feather");
                return false;
            }
            Feather feather2 = levelManager.requestFeather();
            if (feather2 != null) {
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
        levelManager.generateFabric(getCoordinateX(),getCoordinateY());
        if(this.productionCount==2)
        {
            levelManager.generateFabric(getCoordinateX(),getCoordinateY());
        }
    }

    public FabricFactory(int i, int j) {
        super(i, j);
        this.type="fabricfactory";
        this.unitPriceTag=250;
        this.outputTimeout=150;
    }

    public FabricFactory() {
        super();
        this.type="fabricfactory";
        this.unitPriceTag=250;
        this.outputTimeout=150;
    }
}
