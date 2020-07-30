package design_patterns.structural.decorator;

/**
 * Created by gadzik on 30.07.20.
 */
public class BasicCar implements Car {

    @Override
    public void assemble() {
        System.out.print("Basic Car.");
    }

}
