package lozm.practice.factory;

import lozm.practice.Component;
import lozm.practice.code.CoffeeOptions;
import lozm.practice.options.Mocha;
import lozm.practice.options.Soy;
import lozm.practice.options.Whip;

public class OptionsFactory extends PracticeFactory {

    @Override
    protected Component createComponent(Component component, String type) {
        if (type.equals(String.valueOf(CoffeeOptions.SOY))) {
            component = new Soy(component);
        } else if (type.equals(String.valueOf(CoffeeOptions.MOCHA))) {
            component = new Mocha(component);
        } else if (type.equals(String.valueOf(CoffeeOptions.WHIP))) {
            component = new Whip(component);
        }

        return component;
    }

}
