package lozm.state.simple;

public interface State {

    public abstract void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();

}
