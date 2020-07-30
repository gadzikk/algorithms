package arrays;

import java.util.Arrays;

/**
 * Created by gadzik on 11.07.20.
 */
public class RemoveDuplicatesFromArr {
    // https://www.geeksforgeeks.org/remove-duplicates-from-a-given-string/
    static String removeDupsSorted(String str) {
        int res_ind = 1, ip_ind = 1;

        char arr[] = str.toCharArray();

        while (ip_ind != arr.length) {
            if(arr[ip_ind] != arr[ip_ind-1]) {
                arr[res_ind] = arr[ip_ind];
                res_ind++;
            }
            ip_ind++;
        }
        str = new String(arr);
        return str.substring(0,res_ind);
    }

    static String removeDups(String str) {
        char temp[] = str.toCharArray();
        Arrays.sort(temp);
        str = new String(temp);

        return removeDupsSorted(str);
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(removeDups(str));
    }
}
