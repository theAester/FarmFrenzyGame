package control;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;
public  class LogAppender {
    public static void Login(String username) {
        Do("logged in with username " + username);
    }

    public static void Logout(String username) {
        Do("logged out with username " + username);
    }

    public static void Signup(String username) {
        Do("signed up with username" + username);
    }

    public static void WrongPassword(String username, String password)  {
        Do("Invalid password " + username + "(" + password + ")");
    }

    public static void WrongUsername(String username)  {
        Do("No user found as:" + username);
    }

    public static void WrongInput(String input) {
        Do("WRONG INPUT " + input + " ");
    }

    public static void UserExists()  {
        Do("User Exists");
    }

    public static void BuyAnimal(String animal){
     Do(animal+" bought");
    }

    private static void Do(String nextln) {
        try {
            String load = "";
            File LoadAddress = new File("log.txt");
            Scanner scanner = new Scanner(LoadAddress);
            while (scanner.hasNextLine()) {
                load += scanner.nextLine();
                load += "\n";
            }
            scanner.close();
            String next = load;
            next += ">>>>" + nextln + " " + LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)) + ' ' + LocalTime.now();
            FileWriter writer = new FileWriter("log.txt");
            BufferedWriter Bwriter = new BufferedWriter(writer);
            Bwriter.write(next);
            Bwriter.close();
        }
        catch (Exception e){

        }

    }

    public static void NotEnoughMoney()  {
        Do("I dont think you've got the facilities for that big man");
    }

    public static void Pickup(int x,int y){
        Do("Pick up from x,y:"+x+","+y);
    }

    public static void EmptyPoint()  {
        Do("Empty point spotted");
    }
    public static void LevelNotFound(int level)  {
        Do("level not found "+ level);
    }

    public static void InvalidInput(String command) {
        Do("Invalid input while using \""+command+"\"");
    }

    public static void StorageFull() {
        Do("couldn't collect remaining items because the soraqge was full");
    }

    public static void WellRefill() {
        Do("Well refilled");
    }

    public static void wellFail() {
        Do("Well filling failed");
    }

    public static void EmptyWell() {
        Do("Well well well! Well, the well was empty.");
    }

    public static void caged(String name, int i, int j, int remaining) {
        if(remaining != 0) Do("Caged a "+name+" at ("+i+","+j+"). "+remaining+" clicks remaining.");
        else Do("Contained a "+name+" at ("+i+","+j+")");
    }

    public static void DariEshtebahMizaniDadash() {
        Do("Dadashemoon eshteba zad");
    }

    public static void Loaded(String name) {
        Do("Truck loaded with"+name);
    }
    public static void Loaded(String name,int count) {
        Do("Truck loaded with "+count+" "+name+"(s)");
    }

    public static void Unloaded(String name) {
        Do("Truck loaded with"+name);
    }

    public static void truckHasLeft(int carriedMoney) {
        Do("Truck has left for the market with $"+carriedMoney+" worth of items");
    }

    public static void WellRefillStart() {
        Do("Well refill started");
    }

    public static void PlaceFull() {
        Do("watered an already full part of the ground");
    }
}
