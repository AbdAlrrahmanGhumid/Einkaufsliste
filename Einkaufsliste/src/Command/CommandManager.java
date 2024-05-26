package Command;
import java.util.Scanner;
import java.util.LinkedList;



public class CommandManager {
    final static Scanner scanner = new Scanner(System.in);
    private static String getUserInput(){
        return scanner.nextLine();
    }
    private static final CommandManager myCommandManager = new CommandManager();
    private CommandManager(){
        /*insertCommand(new AddCommand());
        insertCommand(new RemoveCommand());
        insertCommand(new ViewCommand());
        insertCommand(new CalculateCommand());
        insertCommand(new ResetCommand());
        insertCommand(new BackToBasketCommand());
        insertCommand(new EndProcessCommand());
        insertCommand(new IssueBillCommand());
        insertCommand(new StartProcessCommand());*/
    }
    public static CommandManager getCommandManager(){
        return myCommandManager;
    }
    LinkedList<Command> commands = new LinkedList<Command>();
    public void insertCommand(Command command){
        commands.add(command);
    }
    public void listenForUser(){
        String [] input = getUserInput().split("\\s+"); // what if input invalid?
        String commandName = input[0];
        boolean validCommand = false;
        for (Command command : commands) {
            if (commandName.equals(command.getName())){
                command.runCommand(input);
                validCommand = true;
            }
        }
        if (!validCommand) Command.invalidInput();
    }
}
