package zobjects;

/**
 * Created by gadzik on 01.08.20.
 */
public class NodeVD {
    public int data;
    public int vd;
    public NodeVD left, right;

    public NodeVD(int data) {
        this.data = data;
        this.vd = Integer.MAX_VALUE;
        this.left = this.right = null;
    }
}
