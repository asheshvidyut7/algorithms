package DynamicProgramming;

import java.io.*;
import java.util.*;
import java.math.*;

/*
When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.

1) If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x with remaining eggs; so the problem reduces to x-1 floors and n-1 eggs
2) If the egg doesn’t break after dropping from the xth floor, then we only need to check for floors higher than x; so the problem reduces to k-x floors and n eggs.

Since we need to minimize the number of trials in worst case, we take the maximum of two cases. We consider the max of above two cases for every floor and choose the floor which yields minimum number of trials.

  k ==> Number of floors
  n ==> Number of Eggs
  eggDrop(n, k) ==> Minimum number of trails needed to find the critical
                    floor in worst case.
  eggDrop(n, k) = 1 + min{max(eggDrop(n - 1, x - 1), eggDrop(n, k - x)):
                 x in {1, 2, ..., k}}
 */
public class EggDroppingPuzzle {
    public static void main(String args[]) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int eggdrop(int n, int k) {
        if (k == 1 || k == 0)
            return k;
        if (n == 1)
            return k;
        int min = Integer.MAX_VALUE, x, res;
        for (x = 1; x <= k; x++) {
            res = Math.max(eggdrop(n - 1, x - 1), eggdrop(n, k - x));
            min = Math.min(min, res);
        }
        return min + 1;
    }
}
