package zobjects;

import trees.*;

/**
 * Created by gadzik on 30.07.20.
 */
public class NodeC {
    public char data;
    public NodeC left, right;

    public NodeC() {
    }

    public NodeC(char item) {
        data = item;
        left = null;
        right = null;
    }
}
