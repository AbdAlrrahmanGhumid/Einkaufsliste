package Programm;
import java.util.Scanner;

public class Mashine {
    private static final Mashine myMashine = new Mashine();
    private Mashine(){}
    public static Mashine getMashine(){
        return myMashine;
    }
    final static Scanner scanner = new Scanner(System.in);
    public static enum State{Starting, Ending, PreStarting};
    private State currentState = State.PreStarting;
    public void setCurrentState(State newCurrentState){
        currentState = newCurrentState;
    }
    public State getCurrentState(){
        return currentState;
    }
    private enum PreStartingContent{startProcess};
    private enum StartingContent{addItem_productName_amount_measurement_prise, 
        removeItemـproductName, 
        calculateToatal, 
        viewContent,
        endProcess, 
        reset};
    private enum EndingContent{issueBill, 
        backToBasket};
    public static void showStartingContent(){
        System.out.println("choose one of the following commands");
        int index = 1;
        for (StartingContent s: StartingContent.values()){
            System.out.print(index + ".  ");
            System.out.println(s);
            index ++;
        }
    }
    public static void showEndingContent(){
        System.out.println("choose one of the following commands:");

        int index = 1;
        for (EndingContent s: EndingContent.values()){
            System.out.print(index + ".  ");
            System.out.println(s);
            index ++;
        }
    }
    public static void showPreStartingContent(){
        System.out.println("choose one of the following commands");
        int index = 1;
        for (PreStartingContent s: PreStartingContent.values()){
            System.out.print(index + ".  ");
            System.out.println(s);
            index ++;
        }
    }

    public void preStartProcess(){
        currentState = State.PreStarting;
        showPreStartingContent();
    }
    public void startProcess(){
        currentState = State.Starting;
        showStartingContent();
    }
    public void endProcess(){
        currentState = State.Ending;
        showEndingContent();
        
    }
    public void backToBasket(){
        currentState = State.Starting;
        showStartingContent();
    }
    public void issueBill(){
        currentState = State.PreStarting;
        Basket.getBasket().viewContent();
        System.out.print("Toatal is ");
        Basket.getBasket().calculateToatal();
        Basket.getBasket().reset();
    }
}
