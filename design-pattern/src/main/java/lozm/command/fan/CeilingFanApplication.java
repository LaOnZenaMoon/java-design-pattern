package lozm.command.fan;

import lozm.command.light.RemoteControlWithUndo;

public class CeilingFanApplication {

    private static final String LIVING_ROOM = "Living room";

    public static void main(String[] args) {
        RemoteControlWithUndo remoteControlWithUndo = new RemoteControlWithUndo();
        CeilingFan ceilingFan = new CeilingFan(LIVING_ROOM);
        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanMediumCommand ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        remoteControlWithUndo.setCommand(0, ceilingFanHighCommand, ceilingFanOffCommand);
        remoteControlWithUndo.setCommand(1, ceilingFanMediumCommand, ceilingFanOffCommand);

        System.out.println("========================================================");

        remoteControlWithUndo.onButtonWasPressed(0);
        remoteControlWithUndo.offButtonWasPressed(0);
        System.out.println("remoteControlWithUndo = " + remoteControlWithUndo);
        remoteControlWithUndo.undoButtonWasPressed();

        System.out.println("========================================================");

        remoteControlWithUndo.offButtonWasPressed(0);
        remoteControlWithUndo.onButtonWasPressed(0);
        System.out.println("remoteControlWithUndo = " + remoteControlWithUndo);
        remoteControlWithUndo.undoButtonWasPressed();
    }

}
