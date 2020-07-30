package design_patterns.behavioral.visitor;

/**
 * Created by gadzik on 29.07.20.
 */
public interface ItemElement {
    int accept(ShoppingCartVisitor visitor);
}
