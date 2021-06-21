//Works just FINE!
package view;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import control.*;
public class Authenticator {
    private String firstName,lastName,hint;
    private Long phoneNumber,password;
    private ArrayList<User> userList;
    private Scanner scanner=new Scanner(System.in);
    private Printer printer=new Printer();
    public Authenticator() {
        this.userList = new ArrayList<>();
        if(Load.UserList()!=null)
        userList=Load.UserList();
    }
    public void Do() throws IOException {
        Printer.Welcome();
        while(true){
            String input=scanner.nextLine();
            input.toLowerCase();
            if(Check(input,"[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z0-9]+"))
            {
                if(!Exists(Split(input)[0]+Split(input)[1]))
                {
                    HashMap<String,Integer> levelMap=new HashMap<>();
                    levelMap.put("eggpowder",1);
                    levelMap.put("bakery",1);
                    levelMap.put("fabricfactory",1);
                    levelMap.put("sewingfactory",1);
                    levelMap.put("milkprocessing",1);
                    levelMap.put("icecreamfactory",1);
                    User user=new User(Split(input)[0],Split(input)[1],Split(input)[2],0,0,0,levelMap);
                    userList.add(user);
                    Printer.Signed();
                    Menu menu=new Menu(user,userList);
                    Save.UserList(userList);
                    LogAppender.Signup(Split(input)[0]+Split(input)[1]);
                }
            }
            else if(Check(input,"[a-zA-Z]+\\s[a-zA-Z0-9]+"))
            {
                if(Find(Split(input)[0],Split(input)[1])!=null)
                {
                    Menu menu=new Menu(Find(Split(input)[0],Split(input)[1]),userList);
                    Printer.Logged();
                    menu.Run();
                    LogAppender.Login(Split(input)[0]);
                    break;
                }
            }
            else if(Check(input,"help"))
            {
                Printer.Help();
            }
            else if(Check(input,"exit"))
            {
                break;
            }
            else {
                //Check if input is a blank RETURN
                if(!input.equals("")) {
                    Printer.WrongInput();
                    LogAppender.WrongInput(input);
                }
            }

        }
    }
    private boolean Check(String input,String regex)
    {
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(input);
        return matcher.find();
    }
    private String[] Split(String string)
    {
        return string.split("\\s");
    }
    private User Find(String username,String password) throws IOException {
        boolean matchedUsername=false;
        boolean matchedPassword=false;
        User temp = null;
        for (User user : userList) {
            if ((user.getFirstName()+user.getLastName()).equals(username)) {
                matchedUsername=true;
                if (user.getPassword().equals(password)) {
                    //user found
                    temp = user;
                    matchedPassword=true;
                }
            }
        }
        if(!matchedUsername){
            LogAppender.WrongUsername(username);
            Printer.UserNotFound();}

        else if         (!matchedPassword){

            LogAppender.WrongPassword(username,password);
       Printer.WrongPassword();
        }
        return temp;
    }
    private boolean Exists(String username) throws IOException {
        boolean exists =false;
        for(User user:userList)
        {
            if ((user.getFirstName()+user.getLastName()).equals(username)) {

                exists =true;
            }
        }
        if(exists)
        {
            Printer.AlreadyExists();
            LogAppender.UserExists();
        }
        return exists;
    }

}
