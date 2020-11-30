package lozm.practice.factory;

import lozm.practice.Component;
import lozm.practice.code.Coffee;
import lozm.practice.coffee.*;

public class CoffeeFactory extends PracticeFactory {

    @Override
    protected Component createComponent(Component component, String type) {
        Component coffee = null;

        if (type.equals(String.valueOf(Coffee.AMERICANO))) {
            coffee = new Americano();
        } else if (type.equals(String.valueOf(Coffee.LATTE))) {
            coffee = new Latte();
        } else if (type.equals(String.valueOf(Coffee.COLD_BREW))) {
            coffee = new ColdBrew();
        } else if (type.equals(String.valueOf(Coffee.ESPRESSO))) {
            coffee = new Espresso();
        } else if (type.equals(String.valueOf(Coffee.CAPPUCCINO))) {
            coffee = new Cappuccino();
        }

        return coffee;
    }

}
