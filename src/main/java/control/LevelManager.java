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
    public int cycleNumber;
    private Level currentLevel;
    private final CommandProcessor cp;
    private final Scanner sc ;
    public LevelManager(Level level){
        currentLevel =level;
        sc = new Scanner(System.in);
        cp = new CommandProcessor(true);
        animals = new ArrayList<>();
        threats = new ArrayList<>();
        facilities = new ArrayList<>();
        commodities =new ArrayList<>();
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
            //update();

            //TODO: draw
            //cycle = output(outputs);

        }
    }
    private void update(){
        cycleNumber += 30;
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
        if(command.equalsIgnoreCase("buy")){
            String name = cp.getArg(0);
            if(name == null){
                LogAppender.InvalidInput("buy");
                Printer.InvalidName();
                return;
            }
            if(buy(name)){
                LogAppender.BuyAnimal(name);
                Printer.BuyAnimal(name);
            }else{
                LogAppender.NotEnoughMoney();
                Printer.NotEnoughMoney();
            }
        }
        else if(command.equalsIgnoreCase("pickup")){
            int x;
            int y;
            try{
                x = Integer.parseInt(cp.getArg(0));
                y = Integer.parseInt(cp.getArg(1));
            }catch(Exception e){
                LogAppender.InvalidInput("pickup");
                Printer.InvalidInput();
                return;
            }
            if(x < 0 || x> 6 || y<0 || y>6){
                LogAppender.InvalidInput("pickup");
                Printer.InvalidRange();
                return;
            }
            ArrayList<Commodity> temp = new ArrayList<>();
            commodities.forEach(e -> {
                if(e.getI() == x && e.getJ() == y){
                    if(!collect(e)){
                        LogAppender.StorageFull();
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
        else if(command.equalsIgnoreCase("well")){
            if(water.reFill() !=0){
                LogAppender.WellRefill();
                Printer.WellRefill();
            }else{
                LogAppender.wellFail();
                Printer.wellFail();
            }
        }
        else if(command.equalsIgnoreCase("plant")){
            int x;
            int y;
            try{
                x = Integer.parseInt(cp.getArg(0));
                y = Integer.parseInt(cp.getArg(1));
            }catch(Exception e){
                LogAppender.InvalidInput("plant");
                Printer.InvalidInput();
                return;
            }
            if(x < 0 || x> 6 || y<0 || y>6){
                LogAppender.InvalidInput("plant");
                Printer.InvalidRange();
                return;
            }
            if(water.takeWater()){
                grid[x][y] = 100;
                Printer.Planted();
            }else{
                LogAppender.EmptyWell();
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
            if(facility.work(this)){

            }
        }
        else if(command.equalsIgnoreCase("cage")){
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
            for (Threat e : threats) {
                if(e.inside(x,y)){
                    e.cage();
                    LogAppender.caged(e.getName(),e.getCoordinateX(),e.getCoordinateY(),e.getRemainingClicks());
                    Printer.caged(e.getName(),e.getCoordinateX(),e.getCoordinateY(),e.getRemainingClicks());
                }
            }
        }
        else if(command.equalsIgnoreCase("truck")){
            if(cp.getArgsCount() == 0){
                LogAppender.DariEshtebahMizaniDadash();
                Printer.DariEshtebahMizaniDadash();
                return;
            }
            if(cp.getArg(0).equalsIgnoreCase("load")){
                if(cp.getArgsCount() == 2){
                    String itemName = cp.getArg(1);
                    Storable item = storage.queryItem(itemName);
                    if(item == null){
                        Printer.ItemNotFound();
                        return;
                    }
                    if(truck.load(item)) {
                        LogAppender.Loaded(itemName);
                        Printer.Loaded();
                    }
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
                    if(truck.loadAll(items)) {
                        LogAppender.Loaded(itemName,count);
                        Printer.Loaded();
                    }
                    else{
                        Printer.NotLoaded();
                        storage.addAll(items);
                    }
                }
                else {
                    LogAppender.DariEshtebahMizaniDadash();
                    Printer.DariEshtebahMizaniDadash();
                }
            }
            else if(cp.getArg(0).equalsIgnoreCase("unload")){
                if(cp.getArgsCount() == 2){
                    String itemName = cp.getArg(1);
                    Storable item = truck.queryItem(itemName);
                    if(item == null){
                        Printer.ItemNotFound();
                        return;
                    }
                    if(storage.add(item)) {
                        LogAppender.Unloaded(itemName);
                        Printer.Unloaded();
                    }
                    else {
                        Printer.NotUnloaded();
                        truck.load(item);
                    }
                }
                else {
                    LogAppender.DariEshtebahMizaniDadash();
                    Printer.DariEshtebahMizaniDadash();
                }
            }
            else if(cp.getArg(0).equalsIgnoreCase("go")){
                truck.ride();
                LogAppender.truckHasLeft(truck.carriedMoney);
                Printer.TruckHasLeft(truck.carriedMoney);
            }
            else{
                LogAppender.DariEshtebahMizaniDadash();
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
        if(name.equalsIgnoreCase("chicken")){
            if(money < 100)return false;
            Chicken chicken = new Chicken();
            animals.add(chicken);
            money-=100;
        }else if(name.equalsIgnoreCase("buffalo")){
            if(money < 400)return false;
            Buffalo buffalo = new Buffalo();
            animals.add(buffalo);
            money-=400;
        }else if(name.equalsIgnoreCase("cat")){
            if(money < 150)return false;
            Cat caet = new Cat();
            animals.add(caet);
            money-=150;
        }else if(name.equalsIgnoreCase("dog")){
            if(money < 100)return false;
            Dog dog = new Dog();
            animals.add(dog);
            money-=100;
        }else if(name.equalsIgnoreCase("turkey")){
            if(money < 200)return false;
            Turkey turkey = new Turkey();
            animals.add(turkey);
            money-=200;
        }else return false;
        return true;
    }

    public Egg requestEgg() {
    }

    public void generatePowder() {
    }


    public Feather requestFeather() {
    }

    public void generateFabric() {
    }
}
