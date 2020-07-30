package design_patterns.behavioral.state;

/**
 * Created by gadzik on 29.07.20.
 */
public class TVContext implements State {

    private State tvState;

    public void setState(State state) {
        this.tvState = state;
    }

    public State getState() {
        return this.tvState;
    }

    @Override
    public void doAction() {
        this.tvState.doAction();
    }


}
