package lozm.practice.coffee;


import lozm.practice.Component;

public class Americano implements Component {

    @Override
    public int cost() {
        return 4000;
    }

    @Override
    public String getDescription() {
        return "아메리카노";
    }

}
