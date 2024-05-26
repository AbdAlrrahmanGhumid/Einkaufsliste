package Command;

import Programm.Basket;
import Programm.Mashine;

public class CalculateCommand extends Command {
    public String getName(){
        return "calculateTotal";
    }
    public void runCommand(String [] args){
        if (Mashine.getMashine().getCurrentState()==Mashine.State.Starting){
            Basket.getBasket().calculateToatal();
            Mashine.showStartingContent();
        } else invalidInput();
    }
}
