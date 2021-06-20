package view;


public class Printer {
    public static void Welcome()
    {
        System.out.println("Welcome to farm frenzy app .");
    }
    public static void Help()
    {
        System.out.println(                "\nSign Up with format name,lastName,password" +
                "\nor Login with format name+lastName,password");
    }
    public static void WrongPassword()
    {
        System.err.println("Wrong password");
    }
    public static void UserNotFound()
    {
        System.err.println("Wrong username");
    }
    public static void Logged()
    {
        System.out.println("You're logged in");
    }
    public static void AlreadyExists()
    {
        System.err.println("Username already exists");
    }
    public static void Signed()
    {
        System.out.println("Signed up");
    }
    public static void WrongInput()
    {
        System.err.println("Wrong input");
    }
    public static void DamagedFile(String path)
    {
        System.err.println("Damaged file ("+path+")");
    }
    public static void Menu()
    {
        System.out.println("MENU:");
    }
    public static void StartLevel(int level){
        System.out.println("Starting level:"+level);
    }
    public static void AccessDenied(int level)
    {
        System.err.println("You don't have access to "+level);
    }
    public static void LoggedOut()
    {
        System.out.println("You're logged out");
    }
    public static void Settings(){
        System.out.println("SETTINGS:");
    }
    public static void HelpSettings()
    {
        System.out.println("blah blah blah");
    }
    public static void BuyAnimal(String animal)
    {
        System.out.println("bought "+animal);
    }
    public static void NotEnoughMoney()
    {
        System.err.println("You don't have enough coins");
    }

    public static void Pickup(int x,int y) {
        System.out.println("Pick up from X:"+x+"Y:"+y);
    }

    public static void NullPoint() {
        System.err.println("Empty point spotted to pickup");
    }
    public static void LevelNotFound(int level)
    {
        System.err.println("No level found as "+level);
    }

    public static void InvalidInput() {
        System.out.println("Wrong input");
    }

    public static void InvalidName() {
        System.out.println("please enter a valid name");
    }

    public static void InvalidRange() {
        System.out.println("Wrong input range");
    }

    public static void StorageFull() {
        System.out.println("Storage full!");
    }

    public static void WellRefill() {
        System.out.println("Well refilled");
    }

    public static void wellFail() {
        System.out.println("Well in not empty yet");
    }

    public static void Planted() {
        System.out.println("Planted!");
    }

    public static void EmptyWell() {
        System.out.println("Well is empty");
    }

    public static void DariEshtebahMizaniDadash() {
        System.out.println("Thats not how you use this command");
    }

    public static void ItemNotFound() {
        System.out.println("Item not found");
    }

    public static void Loaded() {
        System.out.println("item loaded");
    }

    public static void NotLoaded() {
        System.out.println("Not enough space in truck");
    }

    public static void Unloaded() {
        System.out.println("Item unloaded");
    }

    public static void NotUnloaded() {
        System.out.println("Not enough space in storage. Unloading failed.");
    }

    public static void TruckHasLeft(int money) {
        System.out.println("Truck left for the market...\nthe truck is carrying $"+money+" worth of items");
    }

    public static void caged(String name, int i, int j, int remaining) {
        if(remaining != 0) System.out.printf("Caged a %s at (%d,%d). %d clicks remaining.\n",name,i,j,remaining);
        else System.out.printf("Contained a %s at (%d,%d)\n",name , i ,j);
    }

    public static void NotEnough(String product) {
        System.out.println("Not Enough "+ product);
    }

    public static void WellRefillStart() {
        System.out.println("Well refill started");
    }

    public static void wellRefilling() {
        System.out.println("well is being refilled");
    }

    public static void TruckIsTravelling() {
        System.out.println("Truck is travelling...");
    }

    public static void TruckArrived() {
        System.out.println("The mighty truck has returned");
    }

    public static void PlaceFull(int x, int y) {
        System.out.println("location ("+x+", "+y+") is full");
    }

    public static void EmptySpace() {
        System.out.println("empty...");
    }

    public static void generated(String string) {
        System.out.println(string + " generated");
    }

    public static void FacilityWorkStart(String facilityName) {
        System.out.println(facilityName + " started working");
    }

    public static void FacilityWorking(String type) {
        System.out.println(type + " is working...");
    }

    public static void FacilityProduced(String type) {
        System.out.println(type+" is Done processing!");
    }

    public static void LevelDone(int numlevel,int stars,int cycleNumber) {
        System.out.println("level "+numlevel +"done with " +stars+"stars within "+cycleNumber+"cycles");
    }
}

