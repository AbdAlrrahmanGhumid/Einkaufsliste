package Command;
import Programm.*;
public abstract class Command {
    public String getName(){
        return null;
    }
    public void runCommand(String [] args){
    }
    public static void invalidInput(){
        System.out.println("INVALID INPUT!");
        switch (Mashine.getMashine().getCurrentState()) {
            case PreStarting:
                Mashine.showPreStartingContent();
                break;
            case Starting:
                Mashine.showStartingContent();
                break;
            case Ending:
                Mashine.showEndingContent();
                break;
            default:
                break;
        }
    }
}
