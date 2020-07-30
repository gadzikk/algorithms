package design_patterns.behavioral.null_object;

/**
 * Created by gadzik on 29.07.20.
 */
public class Coder extends Emp {
    public Coder(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
