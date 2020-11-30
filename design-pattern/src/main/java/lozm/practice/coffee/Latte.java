package lozm.practice.coffee;

import lozm.practice.Component;

public class Latte implements Component {

    @Override
    public int cost() {
        return 4500;
    }

    @Override
    public String getDescription() {
        return "라떼";
    }

}
