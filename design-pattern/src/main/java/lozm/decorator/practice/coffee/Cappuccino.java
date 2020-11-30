package lozm.decorator.practice.coffee;

import lozm.decorator.practice.Component;

public class Cappuccino implements Component {

    @Override
    public int cost() {
        return 5300;
    }

    @Override
    public String getDescription() {
        return "카푸치노";
    }

}
