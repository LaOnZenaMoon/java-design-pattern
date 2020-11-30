package lozm.decorator.practice.size;

import lozm.decorator.practice.Component;
import lozm.decorator.practice.Decorator;

public class Small implements Decorator {

    private Component component;


    public Small(Component component) {
        this.component = component;
    }


    @Override
    public int cost() {
        return component.cost();
    }

    @Override
    public String getDescription() {
        return component.getDescription() + ", 스몰 사이즈";
    }

}
