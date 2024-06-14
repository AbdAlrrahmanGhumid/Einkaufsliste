package Programm;

import Command.*;

public class App {
    public static void main(String[] args) throws Exception {
        Mashine.getMashine().preStartProcess();
        CommandManager.getCommandManager().insertCommand(new AddCommand());
        CommandManager.getCommandManager().insertCommand(new RemoveCommand());
        CommandManager.getCommandManager().insertCommand(new ViewCommand());
        CommandManager.getCommandManager().insertCommand(new CalculateCommand());
        CommandManager.getCommandManager().insertCommand(new ResetCommand());
        CommandManager.getCommandManager().insertCommand(new BackToBasketCommand());
        CommandManager.getCommandManager().insertCommand(new EndProcessCommand());
        CommandManager.getCommandManager().insertCommand(new IssueBillCommand());
        CommandManager.getCommandManager().insertCommand(new StartProcessCommand());
        while (true) {
            CommandManager.getCommandManager().listenForUser();
        }
    }

}
