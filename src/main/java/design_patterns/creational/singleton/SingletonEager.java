package design_patterns.creational.singleton;

/**
 * Created by gadzik on 25.07.20.
 */
public class SingletonEager {
    private static final SingletonEager instance = new SingletonEager();

    private SingletonEager() {
    }

    public static SingletonEager getInstance() {
        return instance;
    }
}
