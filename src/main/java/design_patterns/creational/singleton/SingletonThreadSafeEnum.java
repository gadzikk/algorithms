package design_patterns.creational.singleton;

/**
 * Created by gadzik on 26.07.20.
 */
public enum SingletonThreadSafeEnum {
    INSTANCE;
    private int count;

    public static SingletonThreadSafeEnum getInstance() {
        return INSTANCE;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void doProcess() {
        System.out.println("Do high memory or CPU consume operation. count :-" + this.count);
    }


}
