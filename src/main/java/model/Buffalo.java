package model;
import control.LevelManager;

import java.util.Random;
public class Buffalo extends Animal{
    public Buffalo(int x, int y)
    {
        super(x,y);
    }
    public Buffalo()
    {
        super();
    }
    @Override
    public void update(LevelManager levelManager)
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
