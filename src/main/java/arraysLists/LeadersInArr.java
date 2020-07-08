package arraysLists;

/**
 * Created by gadzik on 07.07.20.
 */
public class LeadersInArr {
    // https://www.geeksforgeeks.org/leaders-in-an-array/
    void printLeaders(int arr[], int size) {
        int max_from_right =  arr[size-1];
        System.out.print(max_from_right + " ");

        for (int i = size-2; i >= 0; i--) {
            if (max_from_right < arr[i]) {
                max_from_right = arr[i];
                System.out.print(max_from_right + " ");
            }
        }
    }

    public static void main(String[] args) {
        LeadersInArr lead = new LeadersInArr();
        int arr[] = new int[]{16, 17, 4, 3, 5, 2};
        int n = arr.length;
        lead.printLeaders(arr, n);
    }
}
