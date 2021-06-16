package control;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class LevelManager {
    private ArrayList<Animal> animals;
    private ArrayList<Threat> threats;
    private ArrayList<Facility> facilities;
    private ArrayList<Commodity> commodities;
    private int money;
    private Storage storage;
    private Water water;
    private Bike bike;
    public int[][] grid;
    private int goldTime;
    private int goldStars;
    private int silverTime;
    private int silverStars;
    private int bronzeTime;
    private int bronzestars;
    public int cycleNumber;
    private CommandProcessor cp;
    private Scanner sc ;
    public LevelManager(Level level){
        sc = new Scanner(System.in);
        cp = new CommandProcessor(true);
        initialize();
    }
    public void run(){
        ArrayList<String> outputs = new ArrayList<String>();
        boolean cycle = true;
        while(cycle) { // main game cycle

            // input
            //outputs = exec(sc);
            exec(sc);

            // update
            update();

            //TODO: draw

            //output  --todo--> log
            cycle = output(outputs);

        }
    }
    private void update(){
        animals.forEach(x -> {
            x.update(this);
        });
        facilities.forEach(x->{
            x.update(this);
        });
        //if(cycleNumber)
    }
    private void exec(Scanner sc){
        //process command
        cp.process(sc.nextLine());
        String command = cp.getCommand().toLowerCase();

        //command library
        if(command.equals("buy")){
            String name = cp.getArg(0);
            if(name == null){
                System.out.println("please enter a valid name");
                return;
            }
            if(buy(name)){
                System.out.println("Successfully purchased "+name);
            }else{
                System.out.println("You dont have enough money");
            }
        }
    }
    private boolean buy(String name){
        if(name.equals("chicken")){
            if(money < 100)return false;
            Chicken chicken = new Chicken();
            animals.add(chicken);
            money-=100;
        }else if(name.equals("cow")){
            if(money < 400)return false;
            Cow cow = new Cow();
            animals.add(cow);
            money-=400;
        }else if(name.equals("cat")){
            if(money < 150)return false;
            Cat caet = new Cat();
            animals.add(caet);
            money-=150;
        }else if(name.equals("dog")){
            if(money < 100)return false;
            Dog dog = new Dog();
            animals.add(dog);
            money-=100;
        }else if(name.equals("turkey")){
            if(money < 200)return false;
            Turkey turkey = new Turkey();
            animals.add(turkey);
            money-=200;
        }else return false;
        return true;
    }
    public void initialize(){

    }
}
