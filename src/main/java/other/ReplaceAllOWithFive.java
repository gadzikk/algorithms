package other;

/**
 * Created by gadzik on 08.07.20.
 */
public class ReplaceAllOWithFive {
    // https://www.geeksforgeeks.org/replace-0-5-input-integer/
    static int replace0with5(int number) {
        number += calculateAddedValue(number);
        return number;
    }

    private static int calculateAddedValue(int number) {
        int result = 0;
        int decimalPlace = 1;

        if (number == 0) {
            result += (5 * decimalPlace);
        }

        while (number > 0) {
            if (number % 10 == 0){
                // a number divisible by 10, then this is a zero occurrence in the input
                result += (5 * decimalPlace);
            }
            number /= 10;
            decimalPlace *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(replace0with5(1020));
    }
}
