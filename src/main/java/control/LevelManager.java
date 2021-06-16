package control;

import model.*;

import java.lang.reflect.Array;
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
        ArrayList<String> outputs;
        boolean cycle = true;
        while(cycle) { // main game cycle

            // input
//            outputs = exec(sc);
            exec(sc);

            // update
            update();

            //TODO: draw

            //output  --todo--> log
            cycle = output(outputs);

        }
    }
    private void update(){
        ArrayList<Animal> removeList = new ArrayList<>();
        animals.forEach( x-> {
            if(!x.alive){
                removeList.add(x);
            }
        });
        removeList.forEach(x->{
            animals.remove(x);
        });
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
        else if(command.equals("pickup")){
            int x;
            int y;
            try{
                x = Integer.parseInt(cp.getArg(0));
                y = Integer.parseInt(cp.getArg(1));
            }catch(Exception e){
                System.out.println("Wrong input");
                return;
            }
            if(x < 0 || x> 6 || y<0 || y>6){
                System.out.println("Wrong input range");
                return;
            }
            ArrayList<Commodity> temp = new ArrayList<>();
            commodities.forEach(e -> {
                if(e.getI() == x && e.getJ() == y){
                    if(!collect(e)){
                        System.out.println("Storage full!");
                        return;
                    }
                    temp.add(e);
                }
            });
            temp.forEach(e -> {
               commodities.remove(e);
            });
        }
        else if(command.equals("well")){
            if(water.reFill() !=0){
                System.out.println("Well refilled");
            }else System.out.println("Well in not empty yet");
        }
        else if(command.equals("plant")){
            int x;
            int y;
            try{
                x = Integer.parseInt(cp.getArg(0));
                y = Integer.parseInt(cp.getArg(1));
            }catch(Exception e){
                System.out.println("Wrong input");
                return;
            }
            if(x < 0 || x> 6 || y<0 || y>6){
                System.out.println("Wrong input range");
                return;
            }
            if(water.takeWater()){
                grid[x][y] = 100;
                System.out.println("Planted!");
            }else{
                System.out.println("Well is empty");
            }
        }
        else if(command.equals("work")){
            String facilityName = cp.getArg(0);
            if(facilityName == null){
                System.out.println("Please enter a name");
                return;
            }
            Facility facility = facilities.stream().filter(x->x.getType().equals(facilityName)).findFirst().orElse(null);
            if(facility == null){
                System.out.println("counld not find "+facility);
                return;
            }
            if(facility.work()){

            }
        }
    }

    private boolean collect(Commodity e) {
        if(storage.add(e)){
            assertCollection(e);
        }else return false;
    }

    public void removeAnimal(Animal animal)
    {
        animals.remove(animal);
    }
    public void removeThreat(Threat threat)
    {
        threats.remove(threat);
    }
    public void removeCommodity(Commodity commodity)
    {
        commodities.remove(commodity);
    }
    private void assertCollection(Commodity e) {
        System.out.println("> "+e.getName()+" collected!");
    }

    private boolean buy(String name){
        if(name.equals("chicken")){
            if(money < 100)return false;
            Chicken chicken = new Chicken();
            animals.add(chicken);
            money-=100;
        }else if(name.equals("buffalo")){
            if(money < 400)return false;
            Buffalo buffalo = new Buffalo();
            animals.add(buffalo);
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
