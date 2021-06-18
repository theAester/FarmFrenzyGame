package model;
class Tiger extends Threat{
    public Tiger(int x,int y)
    {
        super(x,y);
    }
    @Override
    public int getStoringSize(){
        return storingSize;
    }

    @Override
    public int getUnitPrice() {
        return unitPriceTag;
    }

    public Tiger()
    {
        super();
    }
    @Override
    public void update()
    {
        System.out.println(this.x+this.y);
    }
    @Override
    public void attack() {

    }
}
