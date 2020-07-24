package zobjects;


/**
 * Created by gadzik on 23.07.20.
 */
public class NodeRn {
    public int data;
    public NodeRn next, random;

    public NodeRn(int data) {
        this.data = data;
        this.next = this.random = null;
    }
}

