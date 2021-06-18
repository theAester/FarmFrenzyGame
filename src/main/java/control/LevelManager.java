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

    public int chickenCount;
    public int buffaloCount;
    public int turkeyCount;
    public int catCount;
    public int dogCount;

    public int eggCount;
    public int icecreamCount;
    public int featherCount;
    public int fabricCount;
    public int shirtCount;
    public int milkCount;
    public int bottledMilkCount;
    public int powderCount;
    public int breadCount;

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
            if(x.type.equals("chicken")) chickenCount++;
            if(x.type.equals("buffalo")) buffaloCount++;
            if(x.type.equals("turkey")) turkeyCount++;
            if(x.type.equals("cat")) catCount++;
            if(x.type.equals("dog")) dogCount++;
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
        else if(command.equals("turn")){
            int count = 1;
            if(cp.getArgsCount() == 1){
                try{
                    count = Integer.parseInt(cp.getArg(0));
                }catch(Exception e){
                    LogAppender.InvalidInput("turn");
                    Printer.InvalidInput();
                    return;
                }
                for(int i=0;i<count;i++){
                    update();
                }
                printAll();
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

    private void printAll() {
        System.out.println("turns: "+cycleNumber/30);
        System.out.println("------------------------Map grid------------------------");
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                System.out.print(grid[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("------------------------Animals------------------------");
        animals.forEach(x->{
            System.out.printf("%s %d%% [%d %d]" , x.type,x.getHealth()*10,x.getCoordinateX(),x.getCoordinateY());
        });
        System.out.println("------------------------Threats------------------------");
        threats.forEach(x->{
            System.out.printf("%s %d [%d %d]" , x.type,x.getRemainingClicks(),x.getCoordinateX(),x.getCoordinateY());
        });
        System.out.println("-------------------------Goals-------------------------");
        currentLevel.getLevelGoals().forEach((x,y)->{
            int count=0;

            if(x.equals("chicken")) count = chickenCount;
            else if(x.equals("buffalo")) count = buffaloCount;
            else if(x.equals("turkey")) count = turkeyCount;
            else if(x.equals("cat")) count = catCount;
            else if(x.equals("dog")) count = dogCount;
            else if(x.equals("egg")) count = eggCount;
            else if(x.equals("feather")) count = featherCount;
            else if(x.equals("fabric")) count = fabricCount;
            else if(x.equals("shirt")) count = shirtCount;
            else if(x.equals("powder")) count = powderCount;
            else if(x.equals("bread")) count = breadCount;
            else if(x.equals("milk")) count = milkCount;
            else if(x.equals("bottledmilk")) count = bottledMilkCount;
            else if(x.equals("icecream")) count = icecreamCount;
            else if(x.equals("money")) count = money;

            System.out.printf("%s %d/%d" , x,count,y);
        });
    }

    private boolean collect(Commodity e) {
        if(storage.add(e)){
            assertCollection(e);
            return true;
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
            chickenCount++;
            money-=100;
        }else if(name.equalsIgnoreCase("buffalo")){
            if(money < 400)return false;
            Buffalo buffalo = new Buffalo();
            animals.add(buffalo);
            buffaloCount++;
            money-=400;
        }else if(name.equalsIgnoreCase("cat")){
            if(money < 150)return false;
            Cat caet = new Cat();
            animals.add(caet);
            catCount++;
            money-=150;
        }else if(name.equalsIgnoreCase("dog")){
            if(money < 100)return false;
            Dog dog = new Dog();
            animals.add(dog);
            dogCount++;
            money-=100;
        }else if(name.equalsIgnoreCase("turkey")){
            if(money < 200)return false;
            Turkey turkey = new Turkey();
            animals.add(turkey);
            turkeyCount++;
            money-=200;
        }else return false;
        return true;
    }

    public Egg requestEgg() {
        return storage.queryEgg();
    }

    public void generatePowder(int i, int j) {
        commodities.add(new Powder(i,j));
        powderCount++;
    }


    public Feather requestFeather() {
        return storage.queryFeather();
    }


    public void generateFabric(int coordinateX, int coordinateY) {
        commodities.add(new Fabric(coordinateX,coordinateY));
        fabricCount++;
    }
    //salam
    //yoooo
    public Fabric requestFabric() {
        return storage.queryFabric();
    }

    public void generateShirt(int coordinateX, int coordinateY) {
        commodities.add(new Shirt(coordinateX,coordinateY));
        shirtCount++;
    }

    public void generateBread(int coordinateX, int coordinateY) {
        commodities.add(new Bread(coordinateX,coordinateY));
        breadCount++;
    }
    public Milk requestMilk() {
        return storage.queryMilk();
    }

    public void generateBottledMilk(int coordinateX, int coordinateY) {
        commodities.add(new BottledMilk(coordinateX,coordinateY));
        bottledMilkCount++;
    }

    public void generateIceCream(int coordinateX, int coordinateY) {
        commodities.add(new IceCream(coordinateX,coordinateY));
        icecreamCount++;
    }

    public BottledMilk requestBottledMilk() {
        return storage.queryBottledMilk();
    }

    public Powder requestPowder() {
        return storage.queryPowder();
    }

    public void generateEgg(int coordinateX, int coordinateY) {
        commodities.add(new Egg(coordinateX,coordinateY));
        eggCount++;
    }

    public void generateMilk(int coordinateX, int coordinateY) {
        commodities.add(new Milk(coordinateX,coordinateY));
        milkCount++;
    }

    public void generateFeather(int coordinateX, int coordinateY) {
        commodities.add(new Feather(coordinateX,coordinateY));
        featherCount++;
    }
}
