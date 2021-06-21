package model;

import control.LevelManager;
import view.Printer;

public class SewingFactory extends Facility {
    //khayyati
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
            Fabric fabric = levelManager.requestFabric();
            if (fabric == null) {
                Printer.NotEnough("fabric");
                return false;
            }
            this.productionCount = 1;
            this.outputSeq = 0;
            this.busy = true;
            this.scale=1;
            return true;
        } else if(level == 2) {
            Fabric fabric = levelManager.requestFabric();
            if (fabric == null) {
                Printer.NotEnough("fabric");
                return false;
            }
            Fabric fabric2 = levelManager.requestFabric();
            if (fabric2 != null) {
                this.productionCount = 2;
                this.scale=1;
            } else {
                this.productionCount = 1;
                this.scale=2;
            }
            this.outputSeq = 0;
            this.busy = true;
            return true;
        }else{
            Printer.HaventBought();
            return false;
        }
    }

    @Override
    public void collect() {

    }

    @Override
    public void produce(LevelManager levelManager) {
        levelManager.generateShirt(getCoordinateX(),getCoordinateY());
        if(this.productionCount==2)
        {
            levelManager.generateShirt(getCoordinateX(),getCoordinateY());
        }
    }

    public SewingFactory(int i, int j) {
        super(i, j);
        this.type="sewingfactory";
        this.unitPriceTag=400;
        this.outputTimeout=150;
        this.upgradeFee=550;
    }

    public SewingFactory() {
        super();
        this.type="sewingfactory";
        this.unitPriceTag=400;
        this.outputTimeout=150;
        this.upgradeFee=550;
    }
}
