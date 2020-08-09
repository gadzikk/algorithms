package trees;

/**
 * Created by gadzik on 07.08.20.
 */
public class SumNodesKLevelString2 {
    // https://www.geeksforgeeks.org/sum-nodes-k-th-level-tree-represented-string/
    static int sumAtKthLevel(String tree, int k) {
        int level = -1;
        int sum = 0;
        int n = tree.length();

        for (int i = 0; i < n; i++) {
            if (tree.charAt(i) == '(') {
                level++;
            } else if (tree.charAt(i) == ')') {
                level--;
            } else {
                if (level == k) {
                    sum += (tree.charAt(i) - '0');
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String tree = "(0(5(6()())(4()(9()())))(7(1()())(3()())))";
        int k = 2;
        System.out.println(sumAtKthLevel(tree, k));
    }
}
