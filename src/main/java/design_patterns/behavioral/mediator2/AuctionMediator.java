package design_patterns.behavioral.mediator2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gadzik on 29.07.20.
 */
public class AuctionMediator implements Mediator {

    private List<Buyer> buyers;

    public AuctionMediator() {
        buyers = new ArrayList<>();
    }

    @Override
    public void addBuyer(Buyer buyer) {
        buyers.add(buyer);
        System.out.println(buyer.getName() + " was added to" +
                "the buyers list.");
    }

    @Override
    public void findHighestBidder() {
        int maxBid = 0;
        Buyer winner = null;
        for (Buyer b : buyers) {
            if (b.getPrice() > maxBid) {
                maxBid = b.getPrice();
                winner = b;
            }
        }
        System.out.println("The auction winner is " + winner.getName() + ". He paid " + winner.getPrice() + "$ for the item.");
    }
}
