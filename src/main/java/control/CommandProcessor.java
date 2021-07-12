package control;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CommandProcessor {
    private String commandHeader;
    private int argsCount;
    private int flagCount;
    private HashMap<String, String> flags;
    private ArrayList<String> args;
    private boolean caseInsensitive;
    public CommandProcessor(){
	caseInsensitive = false;
    }
    public CommandProcessor(boolean caseInsensitive){
        this.caseInsensitive = caseInsensitive;
    }

    public boolean process(String command) {
        if(caseInsensitive) command = command.toLowerCase();
        command= command.replace("\\", "\\\\");
        flags = new HashMap<String, String>();
        args = new ArrayList<String>();
        argsCount = 0;
        flagCount = 0;
        Scanner sc = new Scanner(command);
        if(!sc.hasNext()) return false;
        commandHeader = sc.next();
        if (sc.hasNextLine())
            command = sc.nextLine();
        else {
            sc.close();
            return true;
        }
        sc.close();
        Pattern p = Pattern.compile("(-\\w+) (-\\w+)");   //"(-\w) (\S*)");
        Matcher m = p.matcher(command);
        while (m.find()) {
            String stray = m.group(1);
            command = command.replaceAll(stray, "");
            flags.put(stray, "");
            flagCount++;
        }
        p = Pattern.compile("(-\\w+) \"(\\S+)\"");   //"(-\w) (\S*)");
        m = p.matcher(command);
        while (m.find()) {
            String arg = m.group(1);
            String val = m.group(2);
            String search = m.group(0).replace("\\","\\\\");
            command = command.replaceAll(search, "");
            val = val.replace("\\\\","\\");
            flags.put(arg, val);
            flagCount++;
        }
        p = Pattern.compile("(-\\w+) (\\S+)");   //"(-\w) (\S*)");
        m = p.matcher(command);
        while (m.find()) {
            String arg = m.group(1);
            String val = m.group(2);
            command = command.replaceAll(m.group(1) + " " + m.group(2), "");
            flags.put(arg, val);
            flagCount++;
        }
        p = Pattern.compile("(-\\w+)$");   //"(-\w) (\S*)");
        m = p.matcher(command);
        if (m.find()) {
            String arg = m.group(1);
            command = command.replaceAll(m.group(1), "");
            flags.put(arg, "");
            flagCount++;
        }
        sc = new Scanner(command);
        while (sc.hasNext()) {
            args.add(sc.next());
            argsCount++;
        }
        sc.close();
        return true;
    }
    public HashMap<String,String> getAllFlags(){
      HashMap<String,String> bro = new HashMap<>();
      bro.putAll(flags);
      return bro;
    }
    public String getArg(int index) {
        try{
            return args.get(index);
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    public int getArgsCount() {
        return argsCount;
    }

    public String getCommand() {
        return commandHeader;
    }

    public String getFlag(String arg) {
        return flags.get(arg);
    }

    public boolean hasFlag(String arg) {
        return !(flags.get(arg) == null);
    }

    public int getFlagCount() {
        return flagCount;
    }
}
