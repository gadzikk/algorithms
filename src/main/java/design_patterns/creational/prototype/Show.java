package design_patterns.creational.prototype;

/**
 * Created by gadzik on 27.07.20.
 */
public class Show implements PrototypeCapable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Show clone() throws CloneNotSupportedException {
        System.out.println("Cloning Show object..");
        return (Show) super.clone();
    }

    @Override
    public String toString() {
        return "Show";
    }
}
