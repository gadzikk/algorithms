package design_patterns.behavioral.chain_of_responsibility;

/**
 * Created by gadzik on 27.07.20.
 */
public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(Currency cur);
}
