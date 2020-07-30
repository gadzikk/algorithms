package design_patterns.structural.bridge;

/**
 * Created by gadzik on 30.07.20.
 */
public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract public void applyColor();
}
