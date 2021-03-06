package arrays;

/**
 * Created by gadzik on 12.07.20.
 */
public class TwoStacksUsingArr {
    // https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
    int size;
    int top1, top2;
    int arr[];

    TwoStacksUsingArr(int n) {
        arr = new int[n];
        size = n;
        top1 = -1;
        top2 = size;
    }

    void push1(int x) {
        // There is at least one empty space for new element
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
        } else {
            System.out.println("StackUsingLL Overflow");
            System.exit(1);
        }
    }

    void push2(int x) {
        // There is at least one empty space for new element
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
        } else {
            System.out.println("StackUsingLL Overflow");
            System.exit(1);
        }
    }

    int pop1() {
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        } else {
            System.out.println("StackUsingLL Underflow");
            System.exit(1);
        }
        return 0;
    }

    // Method to pop an element from second stack
    int pop2() {
        if (top2 < size) {
            int x = arr[top2];
            top2++;
            return x;
        } else {
            System.out.println("StackUsingLL Underflow");
            System.exit(1);
        }
        return 0;
    }

    // Driver program to test twoStack class
    public static void main(String args[]) {
        TwoStacksUsingArr ts = new TwoStacksUsingArr(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from"
                + " stack1 is " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from"
                + " stack2 is " + ts.pop2());
    }
}
