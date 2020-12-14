package lozm.state.simple;

public class NoQuarterState implements State {

    private BallMachine ballMachine;


    public NoQuarterState(BallMachine ballMachine) {
        this.ballMachine = ballMachine;
    }


    @Override
    public void insertQuarter() {
        System.out.println("동전을 넣으셨습니다.");
        ballMachine.setState(ballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("동전을 넣어주세요.");
    }

    @Override
    public void turnCrank() {
        System.out.println("동전을 넣어주세요.");
    }

    @Override
    public void dispense() {
        System.out.println("동전을 넣어주세요.");
    }
}
