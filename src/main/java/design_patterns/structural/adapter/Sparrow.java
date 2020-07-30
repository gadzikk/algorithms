package design_patterns.structural.adapter;

/**
 * Created by gadzik on 30.07.20.
 */
public class Sparrow implements Bird {
    public void fly() {
        System.out.println("Flying");
    }

    public void makeSound() {
        System.out.println("Chirp Chirp");
    }
}
