package lozm.factory.method;

public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
        this.name = "Chicago sauce and cheese pizza";
        this.dough = "Extra thick crust dough";
        this.sauce = "Plum tomato sauce";

        this.toppings.add("Mozzarella Cheese");
    }

    void cut() {
        System.out.println("Cutting the pizza into square slices.");
    }

}
