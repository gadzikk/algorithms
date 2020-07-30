package design_patterns.behavioral.mediator2;

/**
 * Created by gadzik on 29.07.20.
 */
public class Buyer {
    private Mediator mediator;
    private String name;
    private int price;

    public Buyer(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void bid(int price) {
        this.price = price;
    }

    public void cancelTheBid() {
        this.price = -1;
    }
}
