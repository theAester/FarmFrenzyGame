package model;

import control.LevelManager;

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
    public void update(LevelManager levelManager)
    {
        System.out.println(this.x+this.y);
    }
    @Override
    public void produce()
    {
        System.out.println(1);
    }
}
