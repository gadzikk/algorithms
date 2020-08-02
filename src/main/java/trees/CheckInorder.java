package trees;

/**
 * Created by gadzik on 02.08.20.
 */
public class CheckInorder {
    // https://www.geeksforgeeks.org/check-array-represents-inorder-binary-search-tree-not/
    static boolean isInorder(int[] arr, int n) {
        if (n == 0 || n == 1) {
            return true;
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int arr[] = {19, 23, 25, 30, 45};
        int n = arr.length;
        if (isInorder(arr, n)) {
            System.out.println("Yes");
        } else {
            System.out.println("Non");
        }
    }
}
