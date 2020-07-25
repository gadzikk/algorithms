package zobjects;

/**
 * Created by gadzik on 16.07.20.
 */
public class NodeL {
    public int data;
    public NodeL next;

    public NodeL() {
    }

    public NodeL(int d) {
        data = d;
        next = null;
    }

    public NodeL(int data, NodeL next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeL getNext() {
        return next;
    }

    public void setNext(NodeL next) {
        this.next = next;
    }
}
