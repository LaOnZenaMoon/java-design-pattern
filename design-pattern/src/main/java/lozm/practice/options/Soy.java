package lozm.practice.options;

import lozm.practice.Component;
import lozm.practice.Decorator;

public class Soy implements Decorator {

    private Component component;


    public Soy(Component component) {
        this.component = component;
    }


    @Override
    public int cost() {
        return component.cost() + 500;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + ", 콩";
    }

}
