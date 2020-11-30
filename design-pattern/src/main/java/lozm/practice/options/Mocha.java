package lozm.practice.options;

import lozm.practice.Component;
import lozm.practice.Decorator;

public class Mocha implements Decorator {

    private Component component;


    public Mocha(Component component) {
        this.component = component;
    }


    @Override
    public int cost() {
        return component.cost() + 1000;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + ", 모카";
    }

}
