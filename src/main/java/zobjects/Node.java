package zobjects;

/**
 * Created by gadzik on 17.06.20.
 */
public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
