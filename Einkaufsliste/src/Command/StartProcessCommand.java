package Command;

import Programm.Mashine;

public class StartProcessCommand extends Command {
    public String getName() {
        return "startProcess";
    }

    public void runCommand(String[] args) {
        Mashine.getMashine().automaton.runTransition(getName());
    }
}
