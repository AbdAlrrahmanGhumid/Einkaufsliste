package Command;

import Programm.Mashine;

public class IssueBillCommand extends Command {
    public String getName(){
        return "issueBill";
    }
    public void runCommand(String [] args){
        if (Mashine.getMashine().getCurrentState()==Mashine.State.Ending){
            Mashine.getMashine().issueBill();
            Mashine.showPreStartingContent();
        } else invalidInput();
    }
}
