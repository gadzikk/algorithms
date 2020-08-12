package trees.trees_construct;

/**
 * Created by gadzik on 02.08.20.
 */
public class PostorderBSTFromPreorder {
    // https://www.geeksforgeeks.org/find-postorder-traversal-of-bst-from-preorder-traversal/

    static class INT {
        int data;

        INT(int d) {
            data = d;
        }
    }

    static void findPostOrderUtil(int pre[], int n, int minval, int maxval, INT preIndex) {

        if (preIndex.data == n) {
            return;
        }

        if (pre[preIndex.data] < minval || pre[preIndex.data] > maxval) {
            return;
        }

        int val = pre[preIndex.data];
        preIndex.data++;
        findPostOrderUtil(pre, n, minval, val, preIndex);
        findPostOrderUtil(pre, n, val, maxval, preIndex);
        System.out.print(val + " ");
    }

    // Function to find postorder traversal.
    static void findPostOrder(int pre[], int n) {

        INT preIndex = new INT(0);

        findPostOrderUtil(pre, n, Integer.MIN_VALUE, Integer.MAX_VALUE, preIndex);
    }

    public static void main(String args[]) {
        int pre[] = {40, 30, 35, 80, 100};

        int n = pre.length;

        findPostOrder(pre, n);
    }
}
