package design_patterns.behavioral.state;

/**
 * Created by gadzik on 29.07.20.
 */
public class TVStopState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned OFF");
    }
}
