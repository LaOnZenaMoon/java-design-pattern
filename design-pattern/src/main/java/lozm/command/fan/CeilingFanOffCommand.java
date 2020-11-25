package lozm.command.fan;

import lozm.command.simple.Command;

public class CeilingFanOffCommand implements Command {

    CeilingFan ceilingFan;
    int prevSpeed;


    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }


    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.setOff();

        printSpeed();
    }

    @Override
    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.setHigh();
        } else if (prevSpeed == CeilingFan.MEDIUM) {
            ceilingFan.setMedium();
        } else if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.setLow();
        } else if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.setLow();
        }

        printSpeed();
    }

    private void printSpeed() {
        System.out.println("Ceiling fan speed: " + ceilingFan.getSpeed());
    }

}
