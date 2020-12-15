package lozm.state.simple;

public class BallMachine {

    private State soldState;
    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;
    private State winnerState;

    private State state = soldOutState;
    private int count = 0;

    private String location;


    public BallMachine(int count) {
        this.count = count;

        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        winnerState = new WinnerState(this);

        if (count > 0) {
            state = noQuarterState;
        }
    }

    public BallMachine(String location, int count) {
        this.count = count;

        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        winnerState = new WinnerState(this);

        if (count > 0) {
            state = noQuarterState;
        }

        this.location = location;
    }


    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void releaseBall() {
        System.out.println("A ball comes rolling out the slot...");
        if (count != 0) {
            count -= 1;
        }
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getState() {
        return state;
    }

    public int getCount() {
        return count;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public String getLocation() {
        return location;
    }

}
