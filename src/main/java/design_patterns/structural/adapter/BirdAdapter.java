package design_patterns.structural.adapter;

/**
 * Created by gadzik on 30.07.20.
 */
public class BirdAdapter implements ToyDuck {
    private Bird bird;

    public BirdAdapter(Bird bird) {
        this.bird = bird;
    }

    public void squeak() {
        bird.makeSound();
    }
}
