package design_patterns.creational.singleton;

/**
 * Created by gadzik on 26.07.20.
 */
public class SingletonBillPugh {

    private SingletonBillPugh() {
    }

    private static class SingletonHelper {
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
