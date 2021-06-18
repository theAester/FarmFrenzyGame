package control;

import java.util.Random;

public class LevelManager {

    public boolean CanBuyAnimal(Enum valueOf) {
        return true;
        //TODO
    }
    public boolean canPickup(int parseInt, int parseInt1) {
        Random random=new Random();
        int rand=random.nextInt(2);
        if(rand==0)
            return true;
        else
            return false;
    }
}
