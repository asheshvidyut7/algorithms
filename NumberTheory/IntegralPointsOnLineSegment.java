package NumberTheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 */
/*
    1. Compute the number of integral points in the line segment excluding the end points.
    2. Find the number of points (x,y) on the line segment P1 - P2 satisfy the condition both x and
       y and integers.
    Assume the given points as P1(x1,y1) and P2(x2,y2).
    x1,y1,x2,y2: integers
    Let’s define the following variables:
        dx = abs(x1 - x2). dy = abs(y1 - y2).
    Solution - The number of integral points between P1 and P2 will be equal to gcd(dx,dy)-1.
 */
public class IntegralPointsOnLineSegment {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int tc = Integer.parseInt(in.readLine());
            for (int t = 0; t < tc; t++) {
                String xy[] = (in.readLine()).split(" ");
                long x1 = Long.parseLong(xy[0]);
                long y1 = Long.parseLong(xy[1]);
                long x2 = Long.parseLong(xy[2]);
                long y2 = Long.parseLong(xy[3]);
                long dx = Math.abs(x1 - x2);
                long dy = Math.abs(y1 - y2);
                long gcd = gcd(dx, dy);
                System.out.println(gcd - 1);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static long gcd(long a, long b){
        if(a == 0 || b == 0){
            return a+b;
        }
        return gcd(b,a%b);
    }
}
