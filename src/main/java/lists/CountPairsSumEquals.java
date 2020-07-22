package lists;

import java.util.*;

/**
 * Created by gadzik on 21.07.20.
 */
public class CountPairsSumEquals {
    // https://www.geeksforgeeks.org/count-pairs-two-linked-lists-whose-sum-equal-given-value/
    static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
        int count = 0;

        Collections.sort(head1);
        Collections.sort(head2, Collections.reverseOrder());

        Iterator<Integer> itr1 = head1.iterator();
        Iterator<Integer> itr2 = head2.iterator();

        Integer num1 = itr1.hasNext() ? itr1.next() : null;
        Integer num2 = itr2.hasNext() ? itr2.next() : null;

        while (num1 != null && num2 != null) {
            // if this sum is equal to 'x', then move both the lists to next nodes and increment 'count'
            if ((num1 + num2) == x) {
                num1 = itr1.hasNext() ? itr1.next() : null;
                num2 = itr2.hasNext() ? itr2.next() : null;
                count++;
            } else if ((num1 + num2) > x) {
                // if this sum is greater than x, then move itr2 to next node
                num2 = itr2.hasNext() ? itr2.next() : null;
            } else {
                // else move itr1 to next node
                num1 = itr1.hasNext() ? itr1.next() : null;
            }
        }
        return count;
    }

    static int countPairsHash(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
        int count = 0;

        HashSet<Integer> us = new HashSet<Integer>();

        // insert all the elements of 1st list in the hash table(unordered_set 'us')
        Iterator<Integer> itr1 = head1.iterator();
        while (itr1.hasNext()) {
            us.add(itr1.next());
        }

        Iterator<Integer> itr2 = head2.iterator();
        // for each element of 2nd list
        while (itr2.hasNext()) {
            if (!(us.add(x - itr2.next()))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Integer arr1[] = {3, 1, 5, 7};
        Integer arr2[] = {8, 2, 5, 3};

        LinkedList<Integer> head1 = new LinkedList<>(Arrays.asList(arr1));
        LinkedList<Integer> head2 = new LinkedList<>(Arrays.asList(arr2));
        int x = 10;
        System.out.println("Count = " + countPairs(head1, head2, x));
    }
}
