package design_patterns.behavioral.observer;

/**
 * Created by gadzik on 29.07.20.
 */
public interface Observer {
    void update();
    void setSubject(Subject sub);
}
