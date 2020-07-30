package design_patterns.structural.bridge2;

/**
 * Created by gadzik on 30.07.20.
 */
public class Produce implements Workshop {
    @Override
    public void work() {
        System.out.print("Produced");
    }
}
