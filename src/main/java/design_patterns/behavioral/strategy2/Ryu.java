package design_patterns.behavioral.strategy2;

/**
 * Created by gadzik on 29.07.20.
 */
public class Ryu extends Fighter {
    public Ryu(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super(kickBehavior, jumpBehavior);
    }

    public void display() {
        System.out.println("Ryu");
    }
}
