package trees;

import zobjects.Node;

/**
 * Created by gadzik on 02.08.20.
 */
public class PairsViolatingBST {
    // https://www.geeksforgeeks.org/count-of-pairs-violating-bst-property/
    static int mergeSort(int arr[], int array_size) {
        int temp[] = new int[array_size];
        return _mergeSort(arr, temp, 0, array_size - 1);
    }

    static int _mergeSort(int arr[], int temp[], int left, int right) {
        int mid, inv_count = 0;
        if (right > left) {
            mid = (right + left) / 2;
            inv_count = _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid + 1, right);
            inv_count += merge(arr, temp, left, mid + 1, right);
        }
        return inv_count;
    }

    static int merge(int arr[], int temp[], int left,
                     int mid, int right) {
        int i, j, k;
        int inv_count = 0;

        i = left;
        j = mid;
        k = left;
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
                inv_count = inv_count + (mid - i);
            }
        }

        while (i <= mid - 1) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return inv_count;
    }

    static int[] a;
    static int in;

    static void Inorder(Node node) {
        if (node == null) {
            return;
        }

        Inorder(node.left);
        a[in] = node.data;
        in++;
        Inorder(node.right);
    }

    static int pairsViolatingBST(Node root, int N) {
        if (root == null) {
            return 0;
        }

        in = 0;
        a = new int[N];
        Inorder(root);
        int inversionCount = mergeSort(a, N);

        return inversionCount;
    }

    public static void main(String args[]) {
        int N = 7;
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(10);
        root.right.right = new Node(40);

        System.out.println(pairsViolatingBST(root, N));
    }
}
