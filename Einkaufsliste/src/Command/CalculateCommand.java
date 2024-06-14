package Command;

//import Programm.Basket;
import Programm.Mashine;

public class CalculateCommand extends Command {
    public String getName() {
        return "calculateTotal";
    }

    public void runCommand(String[] args) {
        Mashine.getMashine().automaton.runTransition(getName());
    }
}
