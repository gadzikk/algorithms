package trees;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gadzik on 01.08.20.
 */
public class PostFromPreIn {
    // https://www.techiedelight.com/find-postorder-traversal-binary-tree-from-inorder-preorder-sequence/
    // https://stackoverflow.com/questions/58902003/create-postorder-from-inorder-and-preorder
    public static void printPostorder(int start, int end, int[] preorder, AtomicInteger preIndex, Map<Integer, Integer> map) {
        if (start > end) {
            return;
        }

        // The next element in preorder sequence will be the root node of subtree formed by inorder[start, end]
        int value = preorder[preIndex.getAndIncrement()];

        if (start == end) {
            System.out.print(value + " ");
            return;
        }

        // get the index of root node in inorder sequence to determine the boundary of its left and right subtree
        int i = map.get(value);

        printPostorder(start, i - 1, preorder, preIndex, map);
        printPostorder(i + 1, end, preorder, preIndex, map);
        System.out.print(value + " ");
    }

    // Find postorder traversal of a binary tree from its inorder and
    // preorder sequence. This function assumes that the input is valid
    // i.e. given inorder and preorder sequence forms a binary tree
    public static void findPostorder(int[] inorder, int[] preorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        AtomicInteger preIndex = new AtomicInteger(0);
        System.out.print("Postorder Traversal is: ");
        printPostorder(0, inorder.length - 1, preorder, preIndex, map);
    }

    public static void main(String[] args) {
        /* Consider below tree
                  1
				/   \
			   /	 \
			  2	   3
			 /	   / \
			/	   /   \
		   4	   5	 6
				  / \
				 /   \
				7	 8
		*/

        int[] inorder = {4, 2, 1, 7, 5, 8, 3, 6};
        int[] preorder = {1, 2, 4, 3, 5, 7, 8, 6};

        findPostorder(inorder, preorder);
    }
}
