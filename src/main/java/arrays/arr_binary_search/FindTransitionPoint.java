package arrays.arr_binary_search;

/**
 * Created by gadzik on 08.07.20.
 */
public class FindTransitionPoint {
    // https://www.geeksforgeeks.org/find-transition-point-binary-array/
    public static int indexOfFirstOne(int arr[], int low,
                                      int high) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0)) {
                return mid;
            } else if (arr[mid] == 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    static int findTransitionPoint(int arr[], int n) {
        int lowerBound = 0, upperBound = n - 1;

        while (lowerBound <= upperBound) {
            int mid = (lowerBound + upperBound) / 2;

            if (arr[mid] == 0) {
                lowerBound = mid + 1;
            } else if (arr[mid] == 1) {
                if (arr[mid - 1] == 0) {
                    return mid;
                }
                upperBound = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String args[]) {
        int arr[] = {0, 0, 0, 0, 1, 1};

        int point = findTransitionPoint(arr, arr.length);
//        int point = indexOfFirstOne(arr, 0, arr.length - 1);

        System.out.println(point >= 0 ? "Transition point is " + point
                : "There is no transition point");
    }
}
