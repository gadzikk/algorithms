package arraysLists;

/**
 * Created by gadzik on 01.07.20.
 */
public class MinOperationsConvert {
// https://www.geeksforgeeks.org/minimum-operations-required-to-convert-a-binary-string-to-all-0s-or-all-1s/
    static int minOperations(String str, int n) {
        int count = 0;
        for (int i = 0; i < n - 1; i++)
        {
            if (str.charAt(i) != str.charAt(i + 1))
                count++;
        }
        // Answer is rounding off the (count / 2) to lower
        return (count + 1) / 2;
    }

    public static void main(String[] args)
    {
        String str = "000111";
        int n = str.length();

        System.out.println(minOperations(str, n));
    }
}
