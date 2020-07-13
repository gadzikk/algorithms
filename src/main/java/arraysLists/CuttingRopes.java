package arraysLists;

import java.util.Arrays;

/**
 * Created by gadzik on 12.07.20.
 */
public class CuttingRopes {
    // https://www.geeksforgeeks.org/ropes-left-every-cut/
    public static void cuttringRopes(int Ropes[], int n)
    {
        Arrays.sort(Ropes);

        int singleOperation = 0;

        // min length rope
        int cuttingLenght = Ropes[0];

        // now traverse through the given Ropes in increase order of length
        for (int i = 1; i < n; i++)
        {
            // After cutting if current rope length is greater than '0' that mean all
            // ropes to it's right side are also greater than 0
            if (Ropes[i] - cuttingLenght > 0)
            {
                System.out.print(n - i + " ");
                cuttingLenght = Ropes[i];
                singleOperation++;
            }
        }

        // after first operation all ropes length become zero
        if (singleOperation == 0)
            System.out.print("0");
    }

    public static void main(String[] arg)
    {
        int[] Ropes = { 5, 1, 1, 2, 3, 5 };
        int n = Ropes.length;
        cuttringRopes(Ropes, n);
    }
}
