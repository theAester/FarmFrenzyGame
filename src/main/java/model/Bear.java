package model;
class Bear extends Threat{
    public Bear(int x,int y)
    {
        super(x,y);
    }
    public Bear()
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
