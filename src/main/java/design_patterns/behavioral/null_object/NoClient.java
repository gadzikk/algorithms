package design_patterns.behavioral.null_object;

/**
 * Created by gadzik on 29.07.20.
 */
public class NoClient extends Emp {
    @Override
    public String getName() {
        return "Not Available";
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
