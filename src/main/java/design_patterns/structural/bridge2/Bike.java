package design_patterns.structural.bridge2;

/**
 * Created by gadzik on 30.07.20.
 */
public class Bike extends Vehicle {
    public Bike(Workshop workShop1, Workshop workShop2) {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture() {
        System.out.print("Bike ");
        workShop1.work();
        workShop2.work();
    }
}
