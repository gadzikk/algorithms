package design_patterns.behavioral.chain_of_responsibility;

/**
 * Created by gadzik on 27.07.20.
 */
public class Currency {
    private int amount;

    public Currency(int amt) {
        this.amount = amt;
    }

    public int getAmount() {
        return this.amount;
    }
}
