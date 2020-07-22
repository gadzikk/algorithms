package lists;

/**
 * Created by gadzik on 16.07.20.
 */
public class ConstructLinkedListFrom2DRec {
    // https://www.geeksforgeeks.org/construct-linked-list-2d-matrix/
    static class Node {
        int data;
        Node right;
        Node down;
    }


    static Node construct(int arr[][], int i, int j, int m, int n) {

        if (i > n - 1 || j > m - 1) {
            return null;
        }

        Node temp = new Node();
        temp.data = arr[i][j];
        temp.right = construct(arr, i, j + 1, m, n);
        temp.down = construct(arr, i + 1, j, m, n);
        return temp;
    }

    static void display(Node head) {

        Node Rp;
        Node Dp = head;

        while (Dp != null) {
            Rp = Dp;

            while (Rp != null) {
                System.out.print(Rp.data + " ");
                Rp = Rp.right;
            }
            System.out.println();
            Dp = Dp.down;
        }
    }

    public static void main(String args[]) {
        int arr[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int m = 3, n = 3;
        Node head = construct(arr, 0, 0, m, n);
        display(head);
    }
}
