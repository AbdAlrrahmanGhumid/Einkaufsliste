package Programm;

import java.util.Scanner;
import Abstract.State;
import Abstract.Transition;
import Abstract.Automaton;

public class Mashine {
    final static Scanner scanner = new Scanner(System.in);

    private static String getUserInput() {
        return scanner.nextLine();
    }

    State preStartingState = new State("PreStarting") {
        public void onEnter() {
            currentState = preStartingState;
            showContent();
        }
    };
    State startingState = new State("Starting") {
        public void onEnter() {
            currentState = startingState;
            showContent();
        }
    };
    State endingState = new State("Ending") {
        public void onEnter() {
            currentState = endingState;
            showContent();
        }

        public void onLeave() {
        }
    };

    public Automaton automaton = new Automaton(preStartingState)
            .addTransition("startProcess", preStartingState, startingState, () -> {
                startProcess();
            })
            .addTransition("endProcess", startingState, endingState, () -> {
                endProcess();
            })
            .addTransition("backToBasket", endingState, preStartingState, () -> {
                backToBasket();
            })
            .addTransition("reset", startingState, preStartingState, () -> {
                reset();
            })
            .addTransition("endProcess", endingState, preStartingState, () -> {
                issueBill();
            })
            .addTransition("viewContent", startingState, startingState, () -> {
                viewContent();
            })
            .addTransition("calculateTotal", startingState, startingState, () -> {
                calculateTotal();
            })
            .addTransition("removeItem", startingState, startingState, () -> {
                removeItem();
            })
            .addTransition("addItem", startingState, startingState, () -> {
                addItem();
            })
            .addTransition("loopTransition", startingState, startingState, () -> { // the loopTransition should be hiden
                                                                                   // when "showContent()" command is
                                                                                   // called
                startProcess();
            })
            .addTransition("loopTransition", endingState, endingState, () -> {
                endProcess();
            })
            .addTransition("loopTransition", preStartingState, preStartingState, () -> {
                preStartProcess();
            });

    private static final Mashine myMashine = new Mashine();

    private Mashine() {
    }

    public static Mashine getMashine() {
        return myMashine;
    }

    public void showContent() {
        System.out.println("choose one of the following commands");
        int index = 1;
        for (Transition t : automaton.getTransitions()) {
            if (t.exitState().equals(currentState)) {
                System.out.print(index + ".  ");
                System.out.println(t.name());
                index++;
            }
        }
    }

    private State currentState = preStartingState;

    public void preStartProcess() {
    }

    public void startProcess() {
    }

    public void endProcess() {
    }

    public void backToBasket() {
    }

    public void issueBill() {
        viewContent();
        System.out.print("Toatal is ");
        calculateTotal();
        reset();
    }

    public void addItem() {
        System.out.println("Enter the item discribtion in the following order");
        System.out.println("ItemName Amount Measurement Price Currency");
        String[] input = getUserInput().split("\\s+"); // what if input invalid?
        Product product = new Product();
        product.name = input[0];
        product.amount = Double.parseDouble(input[1]);
        product.measurement = input[2];
        product.price = Double.parseDouble(input[3]);
        product.currency = input[4];
        Basket.getBasket().products.addLast(product);
    }

    public void removeItem() {
        String productName = getUserInput();
        Basket.getBasket().products.removeIf(product -> (product.name.equals(productName)));
    }

    public void removeAll(Product product) { // needs modification
        Basket.getBasket().products.remove(product);
    }

    public void viewContent() {
        System.out.format("+-------------+-------------+--------------+-------------+%n");
        System.out.format("| ProductName | Amount      | Measurement  | Price       |%n");
        System.out.format("+-------------+-------------+--------------+-------------+%n");
        String leftAlignment = "| %-11s | %-11.2f | %-12s | %-11.2f |%n";
        for (Product p : Basket.getBasket().products) {
            System.out.format(leftAlignment, p.name, p.amount, p.measurement, p.price);
            System.out.format("+-------------+-------------+--------------+-------------+%n");
        }
        System.out.println("");
    }

    public void calculateTotal() {
        double total = 0;
        for (Product p : Basket.getBasket().products) {
            total = total + p.price;
        }
        System.out.println(total);
    }

    public void reset() {
        for (Product product : Basket.getBasket().products) {
            removeAll(product);
        }
    }
}
