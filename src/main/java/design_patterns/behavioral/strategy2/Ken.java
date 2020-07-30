package design_patterns.behavioral.strategy2;

/**
 * Created by gadzik on 29.07.20.
 */
public class Ken extends Fighter {
    public Ken(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super(kickBehavior, jumpBehavior);
    }

    public void display() {
        System.out.println("Ken");
    }
}
