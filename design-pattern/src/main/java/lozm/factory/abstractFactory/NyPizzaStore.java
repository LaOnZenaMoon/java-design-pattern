package lozm.factory.abstractFactory;


public class NyPizzaStore extends PizzaStore {

    @Override
    protected AbstractPizza createPizza(String type) {
        AbstractPizza pizza = null;
        PizzaIngredientFactory pizzaIngredientFactory = new NyPizzaIngredientFactory();

        if ("cheese".equals(type)) {
            pizza = new CheesePizza(pizzaIngredientFactory);
        } else if ("clams".equals(type)) {
            pizza = new ClamPizza(pizzaIngredientFactory);
        }

        return pizza;
    }

}
