package Command;

import Programm.Mashine;

public class IssueBillCommand extends Command {
    public String getName() {
        return "issueBill";
    }

    public void runCommand(String[] args) {
        Mashine.getMashine().automaton.runTransition(getName());
    }
}
