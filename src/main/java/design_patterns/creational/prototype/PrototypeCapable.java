package design_patterns.creational.prototype;

/**
 * Created by gadzik on 27.07.20.
 */
public interface PrototypeCapable extends Cloneable {
    PrototypeCapable clone() throws CloneNotSupportedException;
}

