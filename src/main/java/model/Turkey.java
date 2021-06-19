package model;

import control.LevelManager;

import java.util.Random;

public class Turkey extends Animal {
    public Turkey(int i, int j) {
        super(i, j);
        this.C2H = 1;
        this.productionPoint = 0;
        this.productionRate = 90;
        this.type = "turkey";
        this.unitPriceTag = 200;
        this.consumptionPortion = 10;
    }

    public Turkey() {
        super();
        this.C2H = 1;
        this.health = this.maxHealth;
        this.productionPoint = 0;
        this.productionRate = 90;
        this.type = "turkey";
        this.unitPriceTag = 200;
        this.consumptionPortion = 10;
    }

    @Override
    public void update(LevelManager levelManager) {
        this.productionPoint=this.productionPoint+30;
        if (this.productionPoint == this.productionRate) {
            this.productionPoint = 0;
            produce(levelManager);
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
                        this.j--;
                        moved = true;
                    } else {
                        move = 1;
                    }
                }
            }
        } else if (this.consume == true) {
            int min = 100000;
            for (int i1 = 0; i1 < 6; i1++) {
                for (int i2 = 0; i2 < 6; i2++) {
                    if (levelManager.grid[i1][i2] >= consumptionPortion) {
                        int min2 = 1000000;
                        min2 = (i1 - this.i) * (i1 - this.i) + (i2 - this.j) * (i2 - this.j);
                        if (min2 < min) {
                            min = min2;
                            this.iNew = i1;
                            this.jNew = i2;
                        }
                    }
                }
            }
            if (this.iNew != this.i) {
                if (this.iNew > this.i) {
                    this.i++;
                }
                if (this.iNew < this.i) {
                    this.i--;
                }
            } else if (this.jNew != this.j) {
                if (this.jNew > this.j) {
                    this.j++;
                }
                if (this.jNew < this.j) {
                    this.j--;
                }
            } else if (this.jNew == this.j && this.iNew == this.i) {
                eat(levelManager, this.i, this.j);
            }
        }

    }

    @Override
    public void produce(LevelManager levelManager) {
        levelManager.generateFeather(getCoordinateX(), getCoordinateY());
    }
}

