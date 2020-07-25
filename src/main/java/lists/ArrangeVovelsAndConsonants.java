package lists;

/**
 * Created by gadzik on 24.07.20.
 */
public class ArrangeVovelsAndConsonants {
    // https://www.geeksforgeeks.org/arrange-consonants-vowels-nodes-linked-list/
    static class Node {
        char data;
        Node next;
    }

    static Node newNode(char key) {
        Node temp = new Node();
        temp.data = key;
        temp.next = null;
        return temp;
    }

    static void printlist(Node head) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        while (head != null) {
            System.out.print(head.data + " ");
            if (head.next != null) {
                System.out.print("-> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    static boolean isVowel(char x) {
        return (x == 'a' || x == 'e' || x == 'i' ||
                x == 'o' || x == 'u');
    }

    static Node arrange(Node head) {
        Node newHead = head;
        Node latestVowel;
        Node curr = head;

        if (head == null) {
            return null;
        }

        if (isVowel(head.data) == true) {
            latestVowel = head;
        } else {
            while (curr.next != null && !isVowel(curr.next.data)) {
                curr = curr.next;
            }
            if (curr.next == null) {
                return head;
            }
            latestVowel = newHead = curr.next;
            curr.next = curr.next.next;
            latestVowel.next = head;
        }
        while (curr != null && curr.next != null) {
            if (isVowel(curr.next.data) == true) {
                if (curr == latestVowel) {
                    latestVowel = curr = curr.next;
                } else {
                    Node temp = latestVowel.next;
                    latestVowel.next = curr.next;
                    latestVowel = latestVowel.next;
                    curr.next = curr.next.next;
                    latestVowel.next = temp;
                }
            } else {
                curr = curr.next;
            }
        }
        return newHead;
    }

    // Driver code
    public static void main(String[] args) {
        Node head = newNode('a');
        head.next = newNode('b');
        head.next.next = newNode('c');
        head.next.next.next = newNode('e');
        head.next.next.next.next = newNode('d');
        head.next.next.next.next.next = newNode('o');
        head.next.next.next.next.next.next = newNode('x');
        head.next.next.next.next.next.next.next = newNode('i');

        System.out.println("Linked list before : ");
        printlist(head);

        head = arrange(head);

        System.out.println("Linked list after :");
        printlist(head);
    }
}
