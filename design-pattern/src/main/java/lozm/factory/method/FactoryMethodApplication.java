package lozm.factory.method;

public class FactoryMethodApplication {

    public static void main(String[] args) {
        PizzaStore newYorkStore = new NyPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza newYorkPizza = newYorkStore.orderPizza("cheese");
        System.out.println("pizza.getName() = " + newYorkPizza.getName());

        Pizza chicagoPizza = chicagoStore.orderPizza("cheese");
        System.out.println("chicagoPizza.getName() = " + chicagoPizza.getName());
    }

}
