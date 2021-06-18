package model;

import control.LevelManager;

import java.util.Random;

public class Bear extends Threat{
    public Bear(int i,int j)
    {
        super(i,j);
        this.type="bear";
        this.unitPriceTag=400;
        this.storingSize=15;
        this.outputTimeout=150;
    }
    public Bear()
    {
        super();
        this.type="bear";
        this.unitPriceTag=400;
        this.storingSize=15;
        this.outputTimeout=150;
    }
    @Override
    public int getStoringSize(){
        return storingSize;
    }

    @Override
    public boolean inside(int x, int y) {
        return super.inside(x, y);
    }

    @Override
    public void cage() {
        super.cage();
    }

    @Override
    public String getName() {
        return this.type;
    }

    @Override
    public int getUnitPrice() {
        return unitPriceTag;
    }
    @Override
    public void update(LevelManager levelManager)
    {
        levelManager.queryAnimalLocation(getCoordinateX(),getCoordinateY());
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
        levelManager.queryAnimalLocation(getCoordinateX(),getCoordinateY());
    }
    @Override
    public void attack() {
    }
}
