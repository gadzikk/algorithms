package design_patterns.structural.flyweight;

/**
 * Created by gadzik on 30.07.20.
 */
public class Terrorist implements Player {
    private final String TASK;
    private String weapon;

    public Terrorist() {
        TASK = "PLANT A BOMB";
    }

    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void mission() {
        System.out.println("Terrorist with weapon " + weapon + "|" + " Task is " + TASK);
    }
}
