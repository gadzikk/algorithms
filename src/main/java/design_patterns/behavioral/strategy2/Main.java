package design_patterns.behavioral.strategy2;

/**
 * Created by gadzik on 29.07.20.
 */
public class Main {
    public static void main(String args[]) {
        JumpBehavior shortJump = new ShortJump();
        JumpBehavior LongJump = new LongJump();
        KickBehavior tornadoKick = new TornadoKick();

        Fighter ken = new Ken(tornadoKick, shortJump);
        ken.display();

        ken.punch();
        ken.kick();
        ken.jump();

        ken.setJumpBehavior(LongJump);
        ken.jump();
    }
}
