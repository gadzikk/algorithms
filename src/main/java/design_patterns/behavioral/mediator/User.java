package design_patterns.behavioral.mediator;

/**
 * Created by gadzik on 29.07.20.
 */
public class User {
    private ChatMediator mediator;
    private String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public void send(String msg) {
        System.out.println(this.name + ": Sending Message=" + msg);
        mediator.sendMessage(msg, this);
    }

    public void receive(String msg) {
        System.out.println(this.name + ": Received Message:" + msg);
    }

}
