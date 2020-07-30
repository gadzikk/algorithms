package design_patterns.structural.bridge;

/**
 * Created by gadzik on 30.07.20.
 */
public class Pentagon extends Shape {

    public Pentagon(Color color) {
        super(color);
    }

    @Override
    public void applyColor() {
        System.out.print("Pentagon filled with color ");
        color.applyColor();
    }

}
