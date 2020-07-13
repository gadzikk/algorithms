package arraysLists;

/**
 * Created by gadzik on 12.07.20.
 */
public class CalculateTotalFine {
    // https://www.geeksforgeeks.org/calculate-the-total-fine-to-be-collected/
    static int totalFineByMe(int car_num[], int n, int date, int fine) {
        boolean evenDate = false;
        if (date % 2 == 0) {
            evenDate = true;
        }

        int totalFine = 0;
        if (evenDate) {
            for (int i = 0; i < n; i++) {
                if (car_num[i] % 2 != 0) {
                    totalFine += fine;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (car_num[i] % 2 == 0) {
                    totalFine += fine;
                }
            }
        }
        return totalFine;
    }

    static int totFine(int car_num[], int n, int date, int fine) {
        int tot_fine = 0;

        for (int i = 0; i < n; i++) {
            // if both car no and date are odd or both are even, then statement evaluates to true
            if (((car_num[i] ^ date) & 1) == 1) {
                tot_fine += fine;
            }
        }

        return tot_fine;
    }

    // Driver Code
    public static void main(String[] args) {
        int car_num[] = {3, 4, 1, 2, 7, 9};
        int n = car_num.length;
        int date = 15, fine = 250;

        System.out.println(totalFineByMe(car_num, n,
                date, fine));
    }
}
