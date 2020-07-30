package design_patterns.behavioral.visitor;

/**
 * Created by gadzik on 29.07.20.
 */
public interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}
