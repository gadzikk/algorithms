package lists;

/**
 * Created by gadzik on 21.07.20.
 */
public class IsPalindrome {
    // https://www.geeksforgeeks.org/check-linked-list-strings-form-palindrome/
    public static class Node {
        String data;
        Node next;

        public Node(String d) {
            data = d;
            next = null;
        }
    }

    Node head;

    boolean isPalidromeUtil(String str) {
        int length = str.length();

        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }

    boolean isPalindrome() {
        Node node = head;

        String str = "";
        while (node != null) {
            str = str.concat(node.data);
            node = node.next;
        }

        return isPalidromeUtil(str);
    }

    public static void main(String[] args) {
        IsPalindrome list = new IsPalindrome();
        list.head = new Node("a");
        list.head.next = new Node("bc");
        list.head.next.next = new Node("d");
        list.head.next.next.next = new Node("dcb");
        list.head.next.next.next.next = new Node("a");

        System.out.println(list.isPalindrome());
    }
}
