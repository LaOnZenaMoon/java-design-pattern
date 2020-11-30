package lozm.decorator.practice.options;

import lozm.decorator.practice.Component;
import lozm.decorator.practice.Decorator;

public class Whip implements Decorator {

    private Component component;


    public Whip(Component component) {
        this.component = component;
    }


    @Override
    public int cost() {
        return component.cost() + 1500;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + ", 휘핑크림";
    }

}
