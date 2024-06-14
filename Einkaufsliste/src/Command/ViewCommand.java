package Command;

//import Abstract.Automaton;
//import Programm.Basket;
import Programm.Mashine;

public class ViewCommand extends Command {
    public String getName() {
        return "viewContent";
    }

    public void runCommand(String[] args) {
        Mashine.getMashine().automaton.runTransition(getName());
    }
}
