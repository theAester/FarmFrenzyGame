package model;

public class Water {
    public int level;
    public int refilInterval;
    public int refilSeq;
    public int MAX_LEVEL;
    public int total;
    private int left;
    public boolean available;
    public Water(){
        refilInterval = 60;
        total = 5;
        left = total;
        MAX_LEVEL = 2;
        level=1;
        refilSeq =-1;
        available = true;
    }
    public boolean takeWater(){
        if(left != 0 && available){
            left--;
            return true;
        }else {
            available = false;
            return false;
        }
    }

    /**
     * <h3>Update</h3>
     * 0 = idle <br>
     * 1 = refilling <br>
     * 2 = done <br>
     * @return update status
     */
    public int update(){
        if(refilSeq != refilInterval && refilSeq != -1){
            available = false;
            refilSeq += 30;
            return 1;
        }else if(refilSeq == refilInterval){
            available = true;
            refilSeq = -1;
            left = total;
            return 2;
        }
        return 0;
    }
    public boolean reFill(){
        if(left == 0){
            refilSeq = 0;
            available = false;
            return true;
        }else return false;
    }
    public boolean upgrade(){
        if(level<MAX_LEVEL){
            total += level;
            refilInterval -= 30; // TODO: fix value;
            return true;
        }return false;
    }
}
