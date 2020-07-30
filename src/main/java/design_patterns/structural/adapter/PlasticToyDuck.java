package design_patterns.structural.adapter;

/**
 * Created by gadzik on 30.07.20.
 */
public class PlasticToyDuck implements ToyDuck {
    public void squeak() {
        System.out.println("Squeak");
    }
}
