package model;

import control.LevelManager;

import java.util.Random;

public class Chicken extends Animal {
    public Chicken(int i, int j) {
        super(i, j);
        this.productionPoint = 0;
        this.productionRate = 60;
        this.type = "chicken";
        this.unitPriceTag=100;
    }

    public Chicken() {
        super();
        this.health = this.maxHealth;
        this.productionPoint = 0;
        this.productionRate = 60;
        this.type = "chicken";
        this.unitPriceTag=100;
    }

    @Override
    public void update(LevelManager levelManager) {
        this.productionPoint=+30;
        if (this.productionPoint == this.productionRate) {
            this.productionPoint = 0;
            produce();
        }
        this.health--;
        if (this.health <= this.maxHealth / 2) {
            this.consume = true;
            if (this.health == 0) {
                this.alive = false;
            }
        } else {
            this.consume = false;
        }
        if (this.consume == false) {
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
//        else if(this.consume==true)
//        {
//
//        }

    }

    @Override
    public void produce() {
        Egg egg = new Egg(this.i, this.j);
    }
}
