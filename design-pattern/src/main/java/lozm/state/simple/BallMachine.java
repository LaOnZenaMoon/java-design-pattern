package lozm.state.simple;

public class BallMachine {

    private State soldState;
    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;

    private State state = soldOutState;
    private int count = 0;


    public BallMachine(int count) {
        this.count = count;

        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);


    }
}
