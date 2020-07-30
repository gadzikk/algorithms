package design_patterns.behavioral.command2;

/**
 * Created by gadzik on 29.07.20.
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}
