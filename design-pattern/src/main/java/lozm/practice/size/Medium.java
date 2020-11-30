package lozm.practice.size;

import lozm.practice.Component;
import lozm.practice.Decorator;

public class Medium implements Decorator {

    private Component component;


    public Medium(Component component) {
        this.component = component;
    }


    @Override
    public int cost() {
        return component.cost() + 600;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + ", 미디움 사이즈";
    }

}
