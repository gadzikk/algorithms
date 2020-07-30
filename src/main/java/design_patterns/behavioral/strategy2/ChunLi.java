package design_patterns.behavioral.strategy2;

/**
 * Created by gadzik on 29.07.20.
 */
public class ChunLi extends Fighter {
    public ChunLi(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super(kickBehavior, jumpBehavior);
    }

    public void display() {
        System.out.println("ChunLi");
    }
}
