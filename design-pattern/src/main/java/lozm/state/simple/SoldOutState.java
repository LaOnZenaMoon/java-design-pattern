package lozm.state.simple;

public class SoldOutState implements State {

    BallMachine ballMachine;


    public SoldOutState(BallMachine ballMachine) {
        this.ballMachine = ballMachine;
    }


    @Override
    public void insertQuarter() {
        System.out.println("죄송합니다. 매진되었습니다.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("죄송합니다. 매진되었습니다.");
    }

    @Override
    public void turnCrank() {
        System.out.println("죄송합니다.");
    }

    @Override
    public void dispense() {
        System.out.println("잠깐만 기다려주세요. 알맹이가 나가고 있습니다.");
    }

}
