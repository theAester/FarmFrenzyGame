package model;

import java.util.Random;

class Tiger extends Threat {
    public Tiger(int i, int j) {
        super(i, j);
        this.type = "tiger";
        this.unitPriceTag=500;
        this.storingSize=15;
        this.outputTimeout=150;
    }

    @Override
    public String getName() {
        return this.type;
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
    public int getStoringSize() {
        return storingSize;
    }

    @Override
    public int getUnitPrice() {
        return unitPriceTag;
    }

    public Tiger() {
        super();
        this.type="tiger";
        this.unitPriceTag=500;
        this.storingSize=15;
        this.outputTimeout=150;
    }

    @Override
    public void update() {
        boolean moved = false;
        boolean moved2 = false;
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
        if (move == 1) {
            move = 2;
        }
        if (move == 2) {
            move = 1;
        }
        if (move == 3) {
            move = 4;
        }
        if (move == 4) {
            move = 3;
        }
        Random ran2 = new Random();
        int move2 = 0;
        move2 = ran2.nextInt(4);
        move2++;
        while (moved2 == false) {
            if (move2 == 1) {
                if (this.i < 5 && move2 != move) {
                    this.i++;
                    moved2 = true;
                } else {
                    move2++;
                }
            } else if (move2 == 2) {
                if (this.i > 0 && move2 != move) {
                    this.i--;
                    moved2 = true;
                } else {
                    move2++;
                }
            } else if (move2 == 3) {
                if (this.j < 5 && move2 != move) {
                    this.j++;
                    moved2 = true;
                } else {
                    move2++;
                }
            } else if (move2 == 4) {
                if (this.j > 0 && move2 != move) {
                    this.j++;
                    moved2 = true;
                } else {
                    move2 = 1;
                }
            }
        }

    }

    @Override
    public void attack() {

    }
}
