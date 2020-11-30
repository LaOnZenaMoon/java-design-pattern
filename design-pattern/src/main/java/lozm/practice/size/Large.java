package lozm.practice.size;

import lozm.practice.Component;
import lozm.practice.Decorator;

public class Large implements Decorator {

    private Component component;


    public Large(Component component) {
        this.component = component;
    }


    @Override
    public int cost() {
        return component.cost() + 1400;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + ", 라지 사이즈";
    }

}
