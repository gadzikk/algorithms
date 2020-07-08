package arraysLists;

/**
 * Created by gadzik on 07.07.20.
 */
public class FindAllGreaterToRight {
// https://www.techiedelight.com/find-elements-array-greater-than-elements-right/
    public static void find(int[] arr) {
        int max_so_far = Integer.MIN_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {
            // if current element is greater than maximum so far, print it and update max_so_far
            if (arr[i] > max_so_far) {
                max_so_far = arr[i];
                System.out.printf("%d ", arr[i]);
            }
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 10, 4, 6, 3, 5 };
        find(arr);
    }
}
