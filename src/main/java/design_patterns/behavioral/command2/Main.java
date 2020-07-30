package design_patterns.behavioral.command2;

/**
 * Created by gadzik on 29.07.20.
 */
public class Main {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        Stereo stereo = new Stereo();

        remote.setCommand(new LightOnCommand(light));
        remote.buttonWasPressed();

        remote.setCommand(new StereoOnWithCDCommand(stereo));
        remote.buttonWasPressed();

        remote.setCommand(new StereoOffCommand(stereo));
        remote.buttonWasPressed();
    }
}
