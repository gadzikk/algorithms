package trees;

/**
 * Created by gadzik on 09.08.20.
 */
public class LeafsFromPreorderBST {
    // https://www.geeksforgeeks.org/leaf-nodes-preorder-binary-search-treeusing-recursion/
    static int i = 0;

    static boolean isLeaf(int pre[], int n, int min, int max) {
        if (i >= n) {
            return false;
        }

        if (min < pre[i] && pre[i] < max) {
            i++;

            boolean left = isLeaf(pre, n, min, pre[i - 1]);
            boolean right = isLeaf(pre, n, pre[i - 1], max);

            if (!left && !right) {
                System.out.print(pre[i - 1] + " ");
            }

            return true;
        }
        return false;
    }

    static void printLeaves(int preorder[], int n) {

        isLeaf(preorder, n, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    // Driver code
    public static void main(String[] args) {
        int preorder[] = {890, 325, 290, 530, 965};
        int n = preorder.length;
        printLeaves(preorder, n);
    }
}
