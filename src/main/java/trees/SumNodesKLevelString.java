package trees;

/**
 * Created by gadzik on 07.08.20.
 */
public class SumNodesKLevelString {
    // https://www.geeksforgeeks.org/sum-nodes-k-th-level-tree-represented-string/
    static int i;

    static int sumAtKthLevel(String tree, int k, int level) {

        if (tree.charAt(i++) == '(') {
            if (tree.charAt(i) == ')') {
                return 0;
            }

            int sum = 0;

            if (level == k) {
                sum = tree.charAt(i) - '0';
            }

            ++i;
            int leftsum = sumAtKthLevel(tree, k, level + 1);

            ++i;
            int rightsum = sumAtKthLevel(tree, k, level + 1);

            ++i;
            return sum + leftsum + rightsum;
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        String tree = "(0(5(6()())(4()(9()())))(7(1()())(3()())))";
        int k = 2;
        i = 0;
        System.out.print(sumAtKthLevel(tree, k, 0));
    }
}
