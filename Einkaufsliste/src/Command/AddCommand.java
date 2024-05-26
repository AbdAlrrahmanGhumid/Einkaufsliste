package Command;
import Programm.*;

public class AddCommand extends Command{
    public String getName(){
        return "addItem";
    }
    public void runCommand(String [] args){
        // what if we added an element which already exists in the basket but with other values
        // can't we sum them togeather into one element while adding the new values to the old?
        if (Mashine.getMashine().getCurrentState()==Mashine.State.Starting){
            Product product = new Product();
            product.name = args[1];
            product.amount = Double.parseDouble(args[2]);
            product.measurement = args[3];
            product.prise = Double.parseDouble(args[4]);  
            Basket.getBasket().addItem(product);
            Mashine.showStartingContent();
        } else invalidInput();

    }
}
