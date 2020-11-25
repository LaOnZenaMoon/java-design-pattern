package lozm.command.light;

import lozm.command.simple.Light;
import lozm.command.simple.LightOnCommand;

// RemoteLoader
public class RemoteControlApplication {

    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(0, lightOnCommand, lightOffCommand);

        System.out.println("remoteControl = " + remoteControl);

        remoteControl.onButtonWasPressed(0);
        remoteControl.offButtonWasPressed(0);

        System.out.println("========================================================");

        RemoteControlWithUndo remoteControlWithUndo = new RemoteControlWithUndo();
        remoteControlWithUndo.setCommand(0, lightOnCommand, lightOffCommand);

        System.out.println("remoteControlWithUndo = " + remoteControlWithUndo);

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
