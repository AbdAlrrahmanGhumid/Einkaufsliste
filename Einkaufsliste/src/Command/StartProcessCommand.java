package Command;

import Programm.Mashine;

public class StartProcessCommand extends Command {
    public String getName(){
        return "startProcess";
    }
    public void runCommand(String [] args){
        if (Mashine.getMashine().getCurrentState()==Mashine.State.PreStarting){
            Mashine.getMashine().startProcess();
        } else invalidInput();
    }
}