package lozm.practice.factory;

import lozm.practice.Component;
import lozm.practice.code.CoffeeSize;
import lozm.practice.size.Large;
import lozm.practice.size.Medium;
import lozm.practice.size.Small;

public class SizeFactory extends PracticeFactory {

    @Override
    protected Component createComponent(Component component, String type) {
        if (type.equals(String.valueOf(CoffeeSize.SMALL))) {
            component = new Small(component);
        } else if (type.equals(String.valueOf(CoffeeSize.MEDIUM))) {
            component = new Medium(component);
        } else if (type.equals(String.valueOf(CoffeeSize.LARGE))) {
            component = new Large(component);
        }

        return component;
    }

}
