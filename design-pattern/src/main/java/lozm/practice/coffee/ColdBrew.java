package lozm.practice.coffee;

import lozm.practice.Component;

public class ColdBrew implements Component {

    @Override
    public int cost() {
        return 6000;
    }

    @Override
    public String getDescription() {
        return "콜드브루";
    }

}
