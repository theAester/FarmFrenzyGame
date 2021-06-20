package model;

import control.LevelManager;

import java.util.Random;

public class Cat extends Animal{
    public Cat(int i,int j)
    {
        super(i,j);
        this.type="cat";
        this.unitPriceTag=150;
        this.health=10;
    }
    public Cat()
    {
        super();
        this.type="cat";
        this.unitPriceTag=150;
        this.health=10;
    }
    @Override
    public void update(LevelManager levelManager) {
        boolean moved = false;
        if(levelManager.commodities.size() !=0 ){
            int min = 100000;
            Commodity c = levelManager.commodities.get(0);
            for (Commodity x : levelManager.commodities) {
                int len = Math.abs(getCoordinateX() - x.getCoordinateX()) + Math.abs(getCoordinateX() - x.getCoordinateY());
                if(len < min) {
                    min = len;
                    c = x;
                }
            }
            if(c.getCoordinateY() != getCoordinateY()){
                if(c.getCoordinateY() > getCoordinateY()) this.i++;
                else this.i--;
            }
            else if(c.getCoordinateX() != getCoordinateX()){
                if(c.getCoordinateX() > getCoordinateX()) this.j++;
                else this.j--;
            }
            else{
                levelManager.coolerCollect(c);
            }
            return;
        }
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
                    this.j--;
                    moved = true;
                } else {
                    move = 1;
                }
            }
        }

    }

    @Override
    public void produce(LevelManager levelManager)
    {
        System.out.println("cats don't produce anything ,genius."); // they produce kittens. and hatred. a lot of hatred.
    }
}
