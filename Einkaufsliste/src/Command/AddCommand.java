package Command;

import Programm.*;

public class AddCommand extends Command {
    public String getName() {
        return "addItem";
    }

    public void runCommand(String[] args) {
        Mashine.getMashine().automaton.runTransition("addItem");
        // what if we added an element which already exists in the basket but with other
        // values
        // can't we sum them togeather into one element while adding the new values to
        // the old?
    }
}
