package Command;

import Programm.Mashine;

public class BackToBasketCommand extends Command {
    public String getName() {
        return "backToBasket";
    }

    public void runCommand(String[] args) {
        Mashine.getMashine().automaton.runTransition(getName());
    }
}
