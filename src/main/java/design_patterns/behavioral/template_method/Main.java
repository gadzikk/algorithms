package design_patterns.behavioral.template_method;

/**
 * Created by gadzik on 29.07.20.
 */
public class Main {
    public static void main(String[] args) {

        HouseTemplate houseType = new WoodenHouse();
        houseType.buildHouse();
        System.out.println("************");

        houseType = new GlassHouse();
        houseType.buildHouse();
    }
}
