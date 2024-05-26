package Programm;
import java.util.LinkedList;

public class Basket {
    final public LinkedList<Product> products = new LinkedList<Product>();
    private static final Basket myBasket = new Basket();
    private Basket(){}
    public static Basket getBasket(){
        return myBasket;
    }
    public void addItem(Product product){
        myBasket.products.addLast(product);
    }
    public void removeItem(String productName ){
        myBasket.products.removeIf(product ->(product.name.equals(productName)));
    }
    public void removeAll(Product product){
        getBasket().products.remove(product);
    }
    public void viewContent(){
        System.out.format("+-------------+-------------+--------------+-------------+%n");
        System.out.format("| ProductName | Amount      | Measurement  | Prise       |%n");
        System.out.format("+-------------+-------------+--------------+-------------+%n");
        String leftAlignment = "| %-11s | %-11.2f | %-12s | %-11.2f |%n"; 
        for(Product p: products){
            System.out.format(leftAlignment, p.name, p.amount, p.measurement, p.prise);
            System.out.format("+-------------+-------------+--------------+-------------+%n");
        }
        System.out.println("");
    }  
    public void calculateToatal(){
        double total = 0;
        for (Product p : Basket.getBasket().products){
            total = total +p.prise;
        }
        System.out.println(total);
    }  
    public void reset(){
        for (Product product : products) {
            removeAll(product);
        }
    }
}
