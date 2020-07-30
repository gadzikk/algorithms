package design_patterns.structural.bridge;

/**
 * Created by gadzik on 30.07.20.
 */
public class Main {
    public static void main(String[] args) {
        Shape tri = new Triangle(new RedColor());
        tri.applyColor();

        Shape pent = new Pentagon(new GreenColor());
        pent.applyColor();
    }
}
