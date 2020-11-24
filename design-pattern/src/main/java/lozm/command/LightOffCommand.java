package lozm.command;

import lozm.command.simple.Command;
import lozm.command.simple.Light;

public class LightOffCommand implements Command {

    Light light;


    public LightOffCommand(Light light) {
        this.light = light;
    }


    @Override
    public void execute() {
        light.off();
    }

}
