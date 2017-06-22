package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Stack;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
/*
    Following is the complete algorithm.
    1) Create an empty stack.
    2) Start from first bar, and do following for every bar ‘hist[i]‘ where ‘i’ varies from 0 to n-1.
        a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
        b) If this bar is smaller than the top of stack, then keep removing the top of stack while top
        of the stack is greater. Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp]
        as smallest bar. For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and
        ‘right index’ is ‘i’ (current index).
    3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.
 */
public class LargestRectangleHistogram {
    public long areaLargestRectangleHistogram(int hs[]){
        int n = hs.length;
        Stack<Integer> st = new Stack<Integer>();
        long max_area = 0l;
        int i;
        for (i = 0; i < n; i++) {
            if(st.isEmpty() || hs[st.peek()] <= hs[i]) {
                st.push(i);
            }
            else{
                while(!st.isEmpty() && hs[st.peek()] > hs[i]){
                    int tp = st.pop();
                    // we will find the area assuming the tp is the smallest rectangle
                    // so height of rectangle is hs[tp] and for width is
                    // i - st.peek() - 1, we are removing the previous bigger ones after finding
                    // area with it.
                    long larea = hs[tp] * (st.isEmpty() ? i : i - st.peek() - 1);
                    max_area = Math.max(max_area, larea);
                }
                st.push(i);
            }
        }
        while(!st.isEmpty()){
            int tp = st.pop();
            long larea = hs[tp] * (st.isEmpty() ? i : i - st.peek() - 1);
            max_area = Math.max(max_area, larea);
        }
        return max_area;
    }
    public static void main(String[] args) {
        try {
            LargestRectangleHistogram hs = new LargestRectangleHistogram();
            int hist[] = {6, 2, 5, 4, 5, 1, 6};
            System.out.println(hs.areaLargestRectangleHistogram(hist));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
