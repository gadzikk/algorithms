package trees.trees_iterative;

import java.util.Stack;

/**
 * Created by gadzik on 09.08.20.
 */
public class LeafsFromPreorderBST2 {
    // https://www.geeksforgeeks.org/leaf-nodes-preorder-binary-search-tree/
    static void leafNode(int preorder[], int n) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0, j = 1; j < n; i++, j++) {
            boolean found = false;

            if (preorder[i] > preorder[j]) {
                s.push(preorder[i]);
            } else {

                while (!s.isEmpty()) {
                    if (preorder[j] > s.peek()) {
                        s.pop();
                        found = true;
                    } else {
                        break;
                    }
                }
            }

            if (found) {
                System.out.print(preorder[i] + " ");
            }
        }

        // Since rightmost element is always leaf node.
        System.out.println(preorder[n - 1]);
    }

    // Driver code
    public static void main(String[] args) {
        int preorder[] = {890, 325, 290, 530, 965};
        int n = preorder.length;

        leafNode(preorder, n);
    }
}
