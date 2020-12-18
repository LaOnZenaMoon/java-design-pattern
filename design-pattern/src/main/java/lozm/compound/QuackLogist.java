package lozm.compound;

public class QuackLogist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("QuackLogist: " + duck + " just quacked.");
    }
}
