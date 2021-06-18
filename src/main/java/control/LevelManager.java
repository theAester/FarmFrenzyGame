package control;

import model.*;
import view.Printer;

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
    private Truck truck;
    public int[][] grid;
    private int goldTime;
    private int goldStars;
    private int silverTime;
    private int silverStars;
    private int bronzeTime;
    private int bronzestars;
    public int cycleNumber;
    private Level currentLevel;
    private final CommandProcessor cp;
    private final Scanner sc ;
    public LevelManager(Level level){
        currentLevel =level;
        sc = new Scanner(System.in);
        cp = new CommandProcessor(true);
        initialize();
    }
    public void initialize(){
        currentLevel.getAnimalCycle().forEach( x->{
            animals.add(x);
        });
        currentLevel.getFacilityCycle().forEach( x->{
            facilities.add(x);
        });
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
        updateTruck();
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

    private void updateTruck() {
        int status = truck.update();
        if(status == 2){
            money +=truck.carriedMoney;
            truck.reset();
        }
    }

    private void exec(Scanner sc){
        //process command
        cp.process(sc.nextLine());
        String command = cp.getCommand().toLowerCase();
        //command library
        if(command.equals("buy")){
            String name = cp.getArg(0);
            if(name == null){
                Printer.InvalidName();
                return;
            }
            if(buy(name)){
                Printer.BuyAnimal(name);
            }else{
                LogAppender.NotEnoughMoney();
                Printer.NotEnoughMoney();
            }
        }
        else if(command.equals("pickup")){
            int x;
            int y;
            try{
                x = Integer.parseInt(cp.getArg(0));
                y = Integer.parseInt(cp.getArg(1));
            }catch(Exception e){
                Printer.InvalidInput();
                return;
            }
            if(x < 0 || x> 6 || y<0 || y>6){
                Printer.InvalidRange();
                return;
            }
            ArrayList<Commodity> temp = new ArrayList<>();
            commodities.forEach(e -> {
                if(e.getI() == x && e.getJ() == y){
                    if(!collect(e)){
                        Printer.StorageFull();
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
                Printer.WellRefill();
            }else Printer.wellFail();
        }
        else if(command.equals("plant")){
            int x;
            int y;
            try{
                x = Integer.parseInt(cp.getArg(0));
                y = Integer.parseInt(cp.getArg(1));
            }catch(Exception e){
                Printer.InvalidInput();
                return;
            }
            if(x < 0 || x> 6 || y<0 || y>6){
                Printer.InvalidRange();
                return;
            }
            if(water.takeWater()){
                grid[x][y] = 100;
                Printer.Planted();
            }else{
                Printer.EmptyWell();
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
        else if(command.equals("cage")){
            //TODO: for graphics : get x y from mouse
            int x;
            int y;
            try{
                x = Integer.parseInt(cp.getArg(0));
                y = Integer.parseInt(cp.getArg(1));
            }catch(Exception e){
                Printer.InvalidInput();
                return;
            }
//            if(x < 0 || x> 6 || y<0 || y>6){
//                Printer.InvalidRange();
//                return;
//            }
            threats.forEach(e->{
                if(e.inside(x,y)){
                    e.cage();
                }
            });
        }
        else if(command.equals("truck")){
            if(cp.getArgsCount() == 0){
                Printer.DariEshtebahMizaniDadash();
                return;
            }
            if(cp.getArg(0).equals("load")){
                if(cp.getArgsCount() == 2){
                    String itemName = cp.getArg(1);
                    Storable item = storage.queryItem(itemName);
                    if(item == null){
                        Printer.ItemNotFound();
                        return;
                    }
                    if(truck.load(item)) Printer.Loaded();
                    else {
                        Printer.NotLoaded();
                        storage.add(item);
                    }
                }
                else if(cp.getArgsCount() == 3){
                    String itemName = cp.getArg(1);
                    int count =0;
                    try{
                        count = Integer.parseInt(cp.getArg(2));
                    }catch(Exception e){
                        Printer.InvalidInput();
                        return;
                    }
                    ArrayList<Storable> items = storage.queryItem(itemName,count);
                    if(items == null){
                        Printer.ItemNotFound();
                        return;
                    }
                    if(truck.loadAll(items)) Printer.Loaded();
                    else{
                        Printer.NotLoaded();
                        storage.addAll(items);
                    }
                }
                else Printer.DariEshtebahMizaniDadash();
            }
            else if(cp.getArg(0).equals("unload")){
                if(cp.getArgsCount() == 2){
                    String itemName = cp.getArg(1);
                    Storable item = truck.queryItem(itemName);
                    if(item == null){
                        Printer.ItemNotFound();
                        return;
                    }
                    if(storage.add(item)) Printer.Unloaded();
                    else {
                        Printer.NotUnloaded();
                        truck.load(item);
                    }
                }
                else Printer.DariEshtebahMizaniDadash();
            }
            else if(cp.getArg(0).equals("go")){
                truck.ride();
                Printer.TruckHasLeft(truck.carriedMoney);
            }
            else{
                Printer.DariEshtebahMizaniDadash();
                return;
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
        System.out.println(e.getName()+" collected!");
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
}
