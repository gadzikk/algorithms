package design_patterns.behavioral.command;

/**
 * Created by gadzik on 29.07.20.
 */
public class FileInvoker {
    public Command command;

    public FileInvoker(Command c) {
        this.command = c;
    }

    public void execute() {
        this.command.execute();
    }

}
