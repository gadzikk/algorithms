package design_patterns.structural.bridge;

/**
 * Created by gadzik on 30.07.20.
 */
public class Triangle extends Shape {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Triangle filled with color ");
        color.applyColor();
    }

}
