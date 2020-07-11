package zobjects;

/**
 * Created by gadzik on 17.06.20.
 */
public class NodeT {
    public int key, height;
    public NodeT left, right;

    public NodeT(int d)
    {
        key = d;
        height = 1;
    }
}
