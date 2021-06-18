package model;

import control.LevelManager;

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
    public void update(LevelManager levelManager) {
        System.out.println(this.x + this.y);
    }

    @Override
    public void produce()
    {
        System.out.println(1);
    }
}
