package lozm.proxy;

import lozm.state.simple.BallMachine;

public class BallMonitor {

    private BallMachine ballMachine;


    public BallMonitor(BallMachine ballMachine) {
        this.ballMachine = ballMachine;
    }


    public void report() {
        System.out.println("뽑기 기계 위치: " + ballMachine.getLocation());
        System.out.println("현재 재고: " + ballMachine.getCount());
        System.out.println("현재 상태: " + ballMachine.getState());
    }

}
