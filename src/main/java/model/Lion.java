package model;
class Lion extends Threat{
    public Lion(int x,int y)
    {
        super(x,y);
    }
    /*
    @Override
    public int getStoringSize(){
        return 12;
    }
    */
    public Lion()
    {
        super();
    }
    @Override
    public void update()
    {
        System.out.println(this.x+this.y);
    }
    @Override
    public void attack() {

    }
}
