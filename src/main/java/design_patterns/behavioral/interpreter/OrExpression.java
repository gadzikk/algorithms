package design_patterns.behavioral.interpreter;

/**
 * Created by gadzik on 29.07.20.
 */
public class OrExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public boolean interpreter(String con) {
        return expr1.interpreter(con) || expr2.interpreter(con);
    }
}
