package design_patterns.behavioral.observer;

/**
 * Created by gadzik on 29.07.20.
 */
public interface Subject {
    public void register(Observer obj);
    public void unregister(Observer obj);
    public void notifyObservers();
    public Object getUpdate(Observer obj);
}
