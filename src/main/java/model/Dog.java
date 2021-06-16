package model;
public class Dog extends Animal {public static int price;
    public Dog(int x,int y)
    {
        super(x,y);
    }
    public Dog()
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
