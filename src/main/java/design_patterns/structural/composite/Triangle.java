package design_patterns.structural.composite;

/**
 * Created by gadzik on 30.07.20.
 */
public class Triangle implements Shape {

    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Triangle with color " + fillColor);
    }

}
