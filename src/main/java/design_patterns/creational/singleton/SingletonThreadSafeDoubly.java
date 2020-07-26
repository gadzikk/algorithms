package design_patterns.creational.singleton;

/**
 * Created by gadzik on 26.07.20.
 */
public class SingletonThreadSafeDoubly {

    private static SingletonThreadSafeDoubly instance;

    private SingletonThreadSafeDoubly() {
    }

    public static SingletonThreadSafeDoubly getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (SingletonThreadSafeDoubly.class) {
                if (instance == null) {
                    instance = new SingletonThreadSafeDoubly();
                }
            }
        }
        return instance;
    }
}
