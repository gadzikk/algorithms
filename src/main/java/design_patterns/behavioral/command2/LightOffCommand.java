package design_patterns.behavioral.command2;

/**
 * Created by gadzik on 29.07.20.
 */
public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}
