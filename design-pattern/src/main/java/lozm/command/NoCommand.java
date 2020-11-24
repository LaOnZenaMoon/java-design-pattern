package lozm.command;

import lozm.command.simple.Command;

public class NoCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Execute nothing.");
    }

    @Override
    public void undo() {
        System.out.println("Undo Nothing.");
    }

}
