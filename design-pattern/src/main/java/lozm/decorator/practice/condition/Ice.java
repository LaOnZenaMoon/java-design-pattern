package lozm.decorator.practice.condition;

import lozm.decorator.practice.Component;
import lozm.decorator.practice.Decorator;

public class Ice implements Decorator {

    private Component component;


    public Ice(Component component) {
        this.component = component;
    }


    @Override
    public int cost() {
        return component.cost() + 200;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + ", 아이스";
    }

}
