package lozm.decorator.cafe;

public class Soy extends CondimentDecorator {

    Beverage beverage;


    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }


    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 콩";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();

        if (getSize() == Beverage.TALL) {
            cost += 0.50;
        } else if (getSize() == Beverage.MEDIUM) {
            cost += 0.25;
        } else if (getSize() == Beverage.SMALL) {
            cost += 0.10;
        }

        return cost;
    }

}
