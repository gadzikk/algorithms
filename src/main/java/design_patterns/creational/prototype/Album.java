package design_patterns.creational.prototype;

/**
 * Created by gadzik on 27.07.20.
 */
public class Album implements PrototypeCapable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Album clone() throws CloneNotSupportedException {
        System.out.println("Cloning Album object..");
        return (Album) super.clone();
    }

    @Override
    public String toString() {
        return "Album";
    }
}
