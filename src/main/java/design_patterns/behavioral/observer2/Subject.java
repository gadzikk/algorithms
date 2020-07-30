package design_patterns.behavioral.observer2;

/**
 * Created by gadzik on 29.07.20.
 */
public interface Subject {
    void registerObserver(Observer o);
    void unregisterObserver(Observer o);
    void notifyObservers();
}
