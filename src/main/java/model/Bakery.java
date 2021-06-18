package model;
import control.*;
import view.Printer;

class Bakery extends Facility {
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
            Powder powder = levelManager.requestPowder();
            if (powder == null) {
                Printer.NotEnough("powder");
                return false;
            }
            this.productionCount = 1;
            this.outputSeq = 0;
            this.busy = true;
            return true;
        } else {
            Powder powder = levelManager.requestPowder();
            if (powder == null) {
                Printer.NotEnough("powder");
                return false;
            }
            Powder powder2 = levelManager.requestPowder();
            if (powder2 != null) {
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
        levelManager.generateBread(getCoordinateX(),getCoordinateY());
        if(this.productionCount==2)
        {
            levelManager.generateBread(getCoordinateX(),getCoordinateY());
        }
    }
    public Bakery(int i, int j) {
        super(i, j);
        this.type="bakery";
        this.unitPriceTag=250;
        this.outputTimeout=150;
    }
    public Bakery()
    {
        super();
        this.type="bakery";
        this.unitPriceTag=250;
        this.outputTimeout=150;
    }
}
