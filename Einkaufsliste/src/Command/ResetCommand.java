package Command;

import Programm.Mashine;

//import Programm.Mashine;

public class ResetCommand extends Command {
    public String getName() {
        return "reset";
    }

    public void runCommand(String[] args) {
        Mashine.getMashine().automaton.runTransition(getName());
    }
}
