package lozm.factory.abstractFactory;

public class ClamPizza extends AbstractPizza {

    PizzaIngredientFactory pizzaIngredientFactory;


    public ClamPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }


    @Override
    void prepare() {
        System.out.println("Preparing pizza: " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createChesse();
        clams = pizzaIngredientFactory.createClam();
    }
}
