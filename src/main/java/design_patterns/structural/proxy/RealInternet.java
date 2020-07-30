package design_patterns.structural.proxy;

/**
 * Created by gadzik on 30.07.20.
 */
public class RealInternet implements Internet {
    @Override
    public void connectTo(String serverhost) {
        System.out.println("Connecting to " + serverhost);
    }
}
