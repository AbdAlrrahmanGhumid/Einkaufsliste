package Command;

import Programm.Basket;
import Programm.Mashine;

public class ViewCommand extends Command {
    public String getName(){
        return "viewContent";
    }
    public void runCommand(String [] args){
        if (Mashine.getMashine().getCurrentState()==Mashine.State.Starting){
            Basket.getBasket().viewContent();
            Mashine.showStartingContent();
        } else invalidInput();
    }
}
