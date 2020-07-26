package design_patterns.creational.abstract_factory;

/**
 * Created by gadzik on 26.07.20.
 */
public class ComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}
