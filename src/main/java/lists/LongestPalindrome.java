package lists;

import zobjects.NodeL;

/**
 * Created by gadzik on 24.07.20.
 */
public class LongestPalindrome {
    static int countCommon(NodeL a, NodeL b) {
        int count = 0;

        // loop to count coomon in the list starting from node a and b
        for (; a != null && b != null; a = a.next, b = b.next) {
            if (a.data == b.data) {
                ++count;
            } else {
                break;
            }
        }

        return count;
    }

    static int maxPalindrome(NodeL head) {
        int result = 0;
        NodeL prev = null, curr = head;

        // loop till the end of the linked list
        while (curr != null) {
            // The sublist from head to current reversed.
            NodeL next = curr.next;
            curr.next = prev;
            // check for odd length palindrome by finding longest common list elements
            // beginning from prev and from next (We exclude curr)
            result = Math.max(result, 2 * countCommon(prev, next) + 1);
            // check for even length palindrome by finding longest common list elements
            // beginning from curr and from next
            result = Math.max(result, 2 * countCommon(curr, next));
            // update prev and curr for next iteration
            prev = curr;
            curr = next;
        }
        return result;
    }

    // Utility function to create a new list node
    static NodeL newNode(int key) {
        NodeL temp = new NodeL();
        temp.data = key;
        temp.next = null;
        return temp;
    }

    /* Driver code*/
    public static void main(String[] args) {
    /* Let us create a linked lists to test
    the functions
    Created list is a: 2->4->3->4->2->15 */
        NodeL head = newNode(2);
        head.next = newNode(4);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(2);
        head.next.next.next.next.next = newNode(15);

        System.out.println(maxPalindrome(head));
    }
}
