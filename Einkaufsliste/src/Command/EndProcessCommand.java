package Command;

import Programm.Mashine;

public class EndProcessCommand extends Command {
    public String getName() {
        return "endProcess";
    }

    public void runCommand(String[] args) {
        Mashine.getMashine().automaton.runTransition(getName());
    }
}
