package view;
import control.*;
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
        System.err.println("You only got access from one to "+ level);
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
        System.out.println("kossher");
    }
    public static void BuyAnimal(ENUM animal)
    {
        System.out.println("bought "+animal.toString());
    }
}
