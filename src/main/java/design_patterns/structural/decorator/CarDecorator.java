package design_patterns.structural.decorator;

/**
 * Created by gadzik on 30.07.20.
 */
public class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car c) {
        this.car = c;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }

}
