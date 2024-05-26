package Command;
import Programm.*;
public class RemoveCommand extends Command {
    public String getName(){
        return "removeItem";
    }
    public void runCommand(String [] args){
        if (Mashine.getMashine().getCurrentState()==Mashine.State.Starting){
            Basket.getBasket().removeItem(args[1]);
            Mashine.showStartingContent();
            // Basket.getBasket().products.removeIf(product ->(product.name.equals(args[1])));
            // remove the product with the given name in the console args[1]
        }
    }
}
