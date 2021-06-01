package control;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;
public class LogAppender {
    public static void Login(String username) throws IOException {
        Do("logged in with username " + username);
    }

    public static void Logout(String username) throws IOException {
        Do("logged out with username " + username);
    }

    public static void Signup(String username) throws IOException {
        Do("signed up with username" + username);
    }

    public static void WrongPassword(String username, String password) throws IOException {
        Do("Invalid password " + username + "(" + password + ")");
    }

    public static void WrongUsername(String username) throws IOException {
        Do("No user found as:" + username);
    }

    public static void WrongInput(String input) throws IOException {
        Do("WRONG INPUT " + input + " ");
    }

    public static void UserExists() throws IOException {
        Do("User Exists");
    }

    public static void BuyAnimal(String animal,int price, int coins) throws IOException {
     Do(animal+" bought with price "+ price + "remaining coins" + coins);
    }

    private static void Do(String nextln) throws IOException {
        String load = "";
        File LoadAddress = new File("log.txt");
        Scanner scanner = new Scanner(LoadAddress);
        while (scanner.hasNextLine()) {
            load += scanner.nextLine();
            load += "\n";
        }
        scanner.close();
        String next = load;
        next +=">>>>>"+ nextln + " " + LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) + ' ' + LocalTime.now();
        FileWriter writer = new FileWriter("log.txt");
        BufferedWriter Bwriter = new BufferedWriter(writer);
        Bwriter.write(next);
        Bwriter.close();

    }

    public static void NotEnoughmoney() throws IOException {
        Do("lack of money ");
    }

    public static void Pickup(int x,int y) throws IOException {
        Do("PIck up from x,y:"+x+","+y);
    }

    public static void NullPoint() throws IOException {
        Do("Empty point spotted");
    }
    public static void LevelNotFound(int level) throws IOException {
        Do("level not found "+ level);
    }
}
