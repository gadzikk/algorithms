package strings;

import java.util.Stack;

/**
 * Created by gadzik on 02.07.20.
 */
public class ConvertPrefixInfix {
    public String convert(String expression) {

        Stack<String> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            if (isOperator(c)) {
                String s1 = stack.pop();
                String s2 = stack.pop();
                String temp = "(" + s1 + c + s2 + ")";
                stack.push(temp);
            } else {
                stack.push(c + "");
            }
        }

        String result = stack.pop();

        return result;
    }

    boolean isOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String exp = "*-A/BC-/AKL";
        System.out.println("Prefix Expression: " + exp);
        System.out.println("Infix Expression: " + new ConvertPrefixInfix().convert(exp));
    }
}
