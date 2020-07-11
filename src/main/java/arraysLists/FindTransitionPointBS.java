package arraysLists;

/**
 * Created by gadzik on 08.07.20.
 */
public class FindTransitionPointBS {
    // https://www.geeksforgeeks.org/find-transition-point-binary-array/
    static int findTransitionPoint(int arr[], int n)
    {
        // Initialise lower and upper bounnds
        int lowerBound = 0, upperBound = n-1;

        // Perform Binary search
        while (lowerBound <= upperBound)
        {
            // Find mid
            int mid = (lowerBound+upperBound)/2;

            // update lower_bound if mid contains 0
            if (arr[mid] == 0)
                lowerBound = mid+1;

                // If mid contains 1
            else if (arr[mid] == 1)
            {
                // Check if it is the getLeftChildIndex most 1
                // Return mid, if yes
                if (arr[mid-1]==0)
                    return mid;

                // Else update upper_bound
                upperBound = mid-1;
            }
        }
        return -1;
    }


    // Driver method
    public static void main(String args[])
    {
        int arr[] = {0, 0, 0, 0, 1, 1};

        int point = findTransitionPoint(arr, arr.length);

        System.out.println(point >= 0 ? "Transition point is " + point
                : "There is no transition point");
    }
}
