package design_patterns.behavioral.command2;

/**
 * Created by gadzik on 29.07.20.
 */
public class SimpleRemoteControl {
    private Command slot;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
