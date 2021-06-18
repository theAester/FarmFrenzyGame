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

    public static void BuyAnimal(String animal,int price, int coins){
     Do(animal+" bought with price "+ price + "remaining coins" + coins);
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
}
