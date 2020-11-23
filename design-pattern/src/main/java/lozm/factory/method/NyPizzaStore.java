package lozm.factory.method;

public class NyPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;

        if ("cheese".equals(type)) {
            pizza = new NyStyleCheesePizza();
        }

        return pizza;
    }

}
