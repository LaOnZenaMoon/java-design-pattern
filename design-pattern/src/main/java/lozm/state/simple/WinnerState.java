package lozm.state.simple;

public class WinnerState implements State {

    BallMachine ballMachine;


    public WinnerState(BallMachine ballMachine) {
        this.ballMachine = ballMachine;
    }


    @Override
    public void insertQuarter() {
        System.out.println("잠깐만 기다려주세요. 알맹이가 나가고 있습니다.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("이미 알맹이를 뽑으셨습니다.");
    }

    @Override
    public void turnCrank() {
        System.out.println("손잡이는 한 번만 돌려주세요.");
    }

    @Override
    public void dispense() {
        ballMachine.releaseBall();
        if (ballMachine.getCount() == 0) {
            ballMachine.setState(ballMachine.getSoldOutState());
        } else {
            ballMachine.releaseBall();
            if (ballMachine.getCount() > 0) {
                ballMachine.setState(ballMachine.getNoQuarterState());
            } else {
                System.out.println("알맹이가 모두 소진되었습니다.");
                ballMachine.setState(ballMachine.getSoldOutState());
            }
        }
    }

}
