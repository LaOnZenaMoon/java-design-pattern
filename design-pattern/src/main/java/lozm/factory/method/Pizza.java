package lozm.factory.method;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    String name;
    String dough;
    String sauce;
    List toppings = new ArrayList<>();

    void prepare() {
        System.out.println("preparing: " + name);
        System.out.println("Tossing dough: " + dough);
        System.out.println("Adding sauce: " + sauce);

        StringBuffer toppingsToString = new StringBuffer();
        toppingsToString.append("Adding toppings: ");
        for (int i = 0; i < toppings.size(); i++) {
            toppingsToString.append(toppings.get(i).toString());
        }
        System.out.println(toppingsToString.toString());
    }

    void bake() {
        System.out.println("Bake for 25 minutes at 350 degree.");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices.");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box.");
    }

    public String getName() {
        return name;
    }

}
