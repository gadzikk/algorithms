package zobjects;

/**
 * Created by gadzik on 02.08.20.
 */
public class SNode {
    public SNode head;
    public Node t;
    public SNode next;

    public void push(Node k) {
        SNode tmp = new SNode();

        tmp.t = k;
        tmp.next = this.head;
        this.head = tmp;
    }

    public Node pop() {

        SNode st;
        st = this.head;
        head = head.next;

        return st.t;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }

        return false;
    }
}
