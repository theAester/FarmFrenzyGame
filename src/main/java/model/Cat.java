package model;
public class Cat extends Animal{
    public static int price;
    public Cat(int x,int y)
    {
        super(x,y);
    }
    public Cat()
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
