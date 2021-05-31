package model;
class Cow extends Animal{
    public Cow(int x,int y)
    {
        super(x,y);
    }
    public Cow()
    {
        super();
    }
    @Override
    public void update()
    {
        System.out.println(this.x+this.y);
    }
    @Override
    public boolean consume()
    {
        System.out.println(1);
        return true;
    }
    @Override
    public void produce()
    {
        System.out.println(1);
    }
}
