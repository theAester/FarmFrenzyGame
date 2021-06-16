package model;

import control.LevelManager;
import java.util.Random;

public class Chicken extends Animal{
    public Chicken(int x,int y)
    {
        super(x,y);
        productionPoint=0;
        productionRate=2;
    }
    public Chicken()
    {
        super();
        productionPoint=0;
        productionRate=2;
    }
    @Override
    public void update(LevelManager levelManager)
    {
        productionPoint++;
        if(productionPoint==productionRate)
        {
            productionPoint=0;
            Egg egg = new Egg(this.x,this.y);
        }
        health--;
        if (health==maxHealth/2)
        {
            consume=true;
        }
        else
        {
            consume=false;
        }
        if(consume==false)
        {
            boolean moved=false;
            Random ran = new Random();
            int move=0;
            move=ran.nextInt(4);
            move++;
            while(moved==false)
            {
                if(move==1)
                {
                    if(this.x<5)
                    {
                        this.x++;
                        moved=true;
                    }
                    else
                    {
                        move++;
                    }
                }
                else if(move==2)
                {
                    if(this.x>0)
                    {
                        this.x--;
                        moved=true;
                    }
                    else
                    {
                        move++;
                    }
                }
                else if(move==3)
                {
                    if(this.y<5)
                    {
                        this.y++;
                        moved=true;
                    }
                    else
                    {
                        move++;
                    }
                }
                else if(move==4)
                {
                    if(this.y>0)
                    {
                        this.y++;
                        moved=true;
                    }
                    else
                    {
                        move=1;
                    }
                }
            }
        }
//        else if(consume=true)
//        {
//
//        }

    }
    @Override
    public void produce()
    {
        System.out.println(1);
    }
}
