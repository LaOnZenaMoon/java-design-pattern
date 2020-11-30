package lozm.decorator.practice.condition;

import lozm.decorator.practice.Component;
import lozm.decorator.practice.Decorator;

public class Hot implements Decorator {

    private Component component;


    public Hot(Component component) {
        this.component = component;
    }


    @Override
    public int cost() {
        return component.cost();
    }

    @Override
    public String getDescription() {
        return component.getDescription() + ", 따뜻한";
    }

}
