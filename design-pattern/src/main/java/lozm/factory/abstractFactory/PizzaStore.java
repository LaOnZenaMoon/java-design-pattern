package lozm.factory.abstractFactory;

public abstract class PizzaStore {

    protected abstract AbstractPizza createPizza(String type);

    public AbstractPizza orderPizza(String type) {
        AbstractPizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

}
