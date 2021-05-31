package model;

public class MilkProcessing extends Facility {
    @Override
    public void update() {

    }

    @Override
    public void upgrade() {
        this.level++;
    }

    @Override
    public void collect() {

    }

    @Override
    public void produce() {

    }

    public MilkProcessing(int x, int y) {
        super(x, y);
    }

    public MilkProcessing() {
        super();
    }
}
