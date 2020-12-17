package lozm.proxy.remoteProxy;

import lozm.state.simple.BallMachine;

public class BallMonitorApplication {

    public static void main(String[] args) {
        int count = 0;

        if (args.length < 2) {
            System.out.println("BallMachine <name><inventory>");
            System.exit(1);
        }

        count = Integer.parseInt(args[1]);
        BallMachine ballMachine = new BallMachine(args[0], count);
        BallMonitor ballMonitor = new BallMonitor(ballMachine);
        ballMonitor.report();
    }

}
