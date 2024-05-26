package Command;

import Programm.Basket;
import Programm.Mashine;

public class ResetCommand extends Command {
    public String getName(){
        return "reset";
    }
    public void runCommand(String [] args){
        if (Mashine.getMashine().getCurrentState()==Mashine.State.Starting){
            Basket.getBasket().reset();
            Mashine.showStartingContent();
        } else invalidInput();
    }
}
