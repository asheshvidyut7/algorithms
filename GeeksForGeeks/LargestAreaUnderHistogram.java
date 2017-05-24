package GeeksForGeeks;

import java.io.*;
import java.security.acl.LastOwnerException;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 23/05/17
 **/
public class LargestAreaUnderHistogram {
    public static int getArea(int h[]) {
        int n = h.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        int tp;
        int areaTop = 0;
        int i = 0;
        while(i < n) {
            if (s.empty() || h[s.peek()] <= h[i]) {
                s.push(i);
                i++;
            }
            else {
                tp = s.pop();
                areaTop = h[tp] * (s.empty() ? i : i - s.peek() - 1);
                maxArea = Math.max(maxArea, areaTop);
            }
        }
        while(!s.empty()){
            tp = s.pop();
            areaTop = h[tp] * (s.empty() ? i : i - s.peek() - 1);
            maxArea = Math.max(maxArea, areaTop);
        }
        return maxArea;
    }
    public static void main(String args[]) {
        try {
            System.out.println(LargestAreaUnderHistogram.getArea(new int[]{6, 2, 5, 4, 5, 1, 6}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
