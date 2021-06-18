package model;

import control.LevelManager;

import java.util.Random;

public class Cat extends Animal{
    public Cat(int i,int j)
    {
        super(i,j);
        this.type="cat";
        this.unitPriceTag=150;
    }
    public Cat()
    {
        super();
        this.type="cat";
        this.unitPriceTag=150;
    }
    @Override
    public void update(LevelManager levelManager) {
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
    }

    @Override
    public void produce()
    {
        System.out.println("cats don't produce anything ,genius.");
    }
}
