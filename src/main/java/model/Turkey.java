package model;

import control.LevelManager;

public class Turkey extends Animal{
    public Turkey(int x, int y)
    {
        super(x,y);
    }
    public Turkey()
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
