package Programm;

import java.util.LinkedList;

public class Basket {
    final public LinkedList<Product> products = new LinkedList<Product>();
    private static final Basket myBasket = new Basket();

    private Basket() {
    }

    public static Basket getBasket() {
        return myBasket;
    }

}
