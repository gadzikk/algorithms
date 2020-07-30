package design_patterns.behavioral.interpreter;

/**
 * Created by gadzik on 29.07.20.
 */
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    public boolean interpreter(String con) {
        if (con.contains(data)) {
            return true;
        } else {
            return false;
        }
    }
}
