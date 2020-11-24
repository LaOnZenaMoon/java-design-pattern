package lozm.command;

import lozm.command.simple.Command;

public class StereoOnWithCdCommand implements Command {

    Stereo stereo;


    public StereoOnWithCdCommand(Stereo stereo) {
        this.stereo = stereo;
    }


    @Override
    public void execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }

}
