package lozm.compound;

public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        duckSimulator.simulate(duckFactory);
    }

    private void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedHeadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable goose = new GooseAdapter(new Goose());

        System.out.println("Duck Simulator: With composite pattern - Flock");

        Flock flock = new Flock();
        flock.add(redHeadDuck);
        flock.add(duckCall);
        flock.add(rubberDuck);
        flock.add(goose);

        System.out.println("Duck Simulator: Whole flock simulation");

        simulate(flock);

        System.out.println("The ducks quacked " + QuackCounter.getQuackCounts() + "times.");
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }

}
