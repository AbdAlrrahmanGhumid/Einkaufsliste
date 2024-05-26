package Command;

import Programm.Mashine;

public class EndProcessCommand extends Command {
    public String getName(){
        return "endProcess";
    }
    public void runCommand(String [] args){
        if (Mashine.getMashine().getCurrentState()==Mashine.State.Starting){
            Mashine.getMashine().endProcess();
            Mashine.showEndingContent();
        } else invalidInput();
    }
}
