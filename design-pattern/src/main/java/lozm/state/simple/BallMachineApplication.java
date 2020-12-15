package lozm.state.simple;

public class BallMachineApplication {

    public static void main(String[] args) {
        BallMachine ballMachine = new BallMachine(5);

        System.out.println("ballMachine = " + ballMachine);

        ballMachine.insertQuarter();
        ballMachine.turnCrank();

        System.out.println("ballMachine = " + ballMachine);

        ballMachine.insertQuarter();
        ballMachine.turnCrank();

        System.out.println("ballMachine = " + ballMachine);

        ballMachine.insertQuarter();
        ballMachine.turnCrank();

    }

}
