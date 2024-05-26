package Command;

import Programm.Mashine;

public class BackToBasketCommand extends Command {
    public String getName(){
        return "backToBasket";
    }
    public void runCommand(String [] args){
        if (Mashine.getMashine().getCurrentState()==Mashine.State.Ending){
            Mashine.getMashine().backToBasket();
            Mashine.showStartingContent();
        } else invalidInput();
    }
}
