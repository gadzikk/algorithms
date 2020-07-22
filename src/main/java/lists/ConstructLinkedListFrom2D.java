package lists;

/**
 * Created by gadzik on 16.07.20.
 */
public class ConstructLinkedListFrom2D {
    // https://www.geeksforgeeks.org/construct-a-linked-list-from-2d-matrix-iterative-approach/
    class Node {
        int data;
        Node right, down;

        Node() {
            this.right = null;
            this.down = null;
        }

        Node(int d) {
            this.data = d;
            this.right = null;
            this.down = null;
        }
    }

    Node constructLinkedMatrix(int[][] arr, int m, int n) {
        Node mainHead = null;
        // stores the head of linked lists of each row
        Node[] head = new Node[m];
        Node rightTemp = new Node();
        Node newptr;

        // Firstly, we create m linked lists by setting all the right nodes of every row
        for (int i = 0; i < m; i++) {
            // initially set the head of ith row as NULL
            head[i] = null;
            for (int j = 0; j < n; j++) {
                newptr = new Node(arr[i][j]);

                // stores the mat[0][0] node as the mainhead of the linked list
                if (mainHead == null) {
                    mainHead = newptr;
                }
                if (head[i] == null) {
                    head[i] = newptr;
                } else {
                    rightTemp.right = newptr;
                }
                rightTemp = newptr;
            }
        }

        // Then, for every ith and (i+1)th list, we set the down pointers of every node of ith list
        // with its corresponding node of (i+1)th list
        for (int i = 0; i < m - 1; i++) {
            Node temp1 = head[i];
            Node temp2 = head[i + 1];

            while (temp1 != null && temp2 != null) {
                temp1.down = temp2;
                temp1 = temp1.right;
                temp2 = temp2.right;
            }
        }
        return mainHead;
    }

    void display(Node head) {
        Node rightPosition, downPosition = head;

        while (downPosition != null) {
            rightPosition = downPosition;

            while (rightPosition != null) {
                System.out.print(rightPosition.data + " ");
                rightPosition = rightPosition.right;
            }
            System.out.println();
            downPosition = downPosition.down;
        }
    }

    // Driver Code
    public static void main(String[] args) {
        ConstructLinkedListFrom2D Obj = new ConstructLinkedListFrom2D();
        int m = 3, n = 3; // m = rows and n = columns

        // 2-D Matrix
        int[][] arr =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };

        Node head = Obj.constructLinkedMatrix(arr, m, n);
        Obj.display(head);
    }

}
