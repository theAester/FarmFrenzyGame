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
        System.out.println("Menu:");
    }
}
