package lozm.decorator.practice.coffee;

import lozm.decorator.practice.Component;

public class Espresso implements Component {

    @Override
    public int cost() {
        return 4200;
    }

    @Override
    public String getDescription() {
        return "에스프레소";
    }

}
