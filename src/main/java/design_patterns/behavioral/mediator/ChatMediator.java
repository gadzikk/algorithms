package design_patterns.behavioral.mediator;

/**
 * Created by gadzik on 29.07.20.
 */
public interface ChatMediator {
    public void sendMessage(String msg, User user);

    void addUser(User user);

}
