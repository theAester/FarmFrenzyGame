//Works just FINE!
package view;
import java.io.IOException;
import java.util.ArrayList;
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
                    User user=new User(Split(input)[0],Split(input)[1],Split(input)[2],0,0,0,null,true);
                    userList.add(user);
                    Printer.Signed();
                    Menu menu=new Menu(user);
                    Save.UserList(userList);
                }
            }
            else if(Check(input,"[a-zA-Z]+\\s[a-zA-Z0-9]+"))
            {
                if(Find(Split(input)[0],Split(input)[1])!=null)
                {
                    Menu menu=new Menu(Find(Split(input)[0],Split(input)[1]));
                    Printer.Logged();
                    menu.Run();
                    break;
                }
            }
            else if(Check(input,"help"))
            {
                Printer.Help();
            }
            else
            {
                //Check if input is a blank RETURN
                if(!input.equals(""))
                Printer.WrongInput();
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
    private User Find(String username,String password) {
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
            Printer.UserNotFound();}
        else{
        if(!matchedPassword)
            Printer.WrongPassword();}
        return temp;
    }
    private boolean Exists(String username)
    {
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
        }
        return exists;
    }

}
