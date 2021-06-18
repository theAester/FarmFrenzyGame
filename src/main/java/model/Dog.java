package model;

import control.LevelManager;

import java.util.Random;

public class Dog extends Animal {
    public Dog(int i,int j)
    {
        super(i,j);
        this.type="dog";
        this.unitPriceTag=100;
    }
    public Dog()
    {
        super();
        this.type="dog";
        this.unitPriceTag=100;
    }
    @Override
    public void update(LevelManager levelManager)
    {
        levelManager.queryThreatLocation(getCoordinateX(),getCoordinateY());
        boolean moved = false;
        Random ran = new Random();
        int move = 0;
        move = ran.nextInt(4);
        move++;
        while (moved == false) {
            if (move == 1) {
                if (this.i < 5) {
                    this.i++;
                    moved = true;
                } else {
                    move++;
                }
            } else if (move == 2) {
                if (this.i > 0) {
                    this.i--;
                    moved = true;
                } else {
                    move++;
                }
            } else if (move == 3) {
                if (this.j < 5) {
                    this.j++;
                    moved = true;
                } else {
                    move++;
                }
            } else if (move == 4) {
                if (this.j > 0) {
                    this.j++;
                    moved = true;
                } else {
                    move = 1;
                }
            }
        }
        levelManager.queryThreatLocation(getCoordinateX(),getCoordinateY());
    }
    @Override
    public void produce(LevelManager levelManager)
    {
        System.out.println("Dogs don't produce anything ,genius.");
    }
}
