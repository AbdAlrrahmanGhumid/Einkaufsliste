package Command;

import Programm.Mashine;

//import Programm.*;
public class RemoveCommand extends Command {
    public String getName() {
        return "removeItem";
    }

    public void runCommand(String[] args) {
        Mashine.getMashine().automaton.runTransition(getName());
    }
}
