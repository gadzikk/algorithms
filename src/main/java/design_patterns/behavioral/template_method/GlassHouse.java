package design_patterns.behavioral.template_method;

/**
 * Created by gadzik on 29.07.20.
 */
public class GlassHouse extends HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building Glass Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with glass coating");
    }

}
