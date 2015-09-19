package Geometry.ComputationalGeometry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 */
/*
    Graham Scan Algorithm for Convex Hull.
    *** Time Complexity *** O(nlogn)
    Jarvis Algorithm also computes Convex Hull, but the worst case time complexity is O(n^2)
    Graham Scan Algorithm worst case is O(nlogn)
    Orientation of Points can be . counterclockwise, clockwise, collinear. For that
    we have to use the area of triangle which is (det(x1 y1 1))/2
                                                     x2 y2 1
                                                     x3 y3 1
    if this area if positive then orientation is counter clockwise.
    if the area is negative then the orientation is clockwise.

    Algorithm. Find the leftmost and rightmost points A and B (if several such points,
    then we take the very bottom of the left and right of the top-most). It is clear that A, B
    and certainly fall within a convex hull.

    Next, draw through them straight AB, dividing the set of all points on the upper and
    lower subsets S1 and S2 (the point lying on the line can be attributed to any set -
    they still will not be included in the shell). Points A and B are assigned to both sets.

    Now we construct the upper shell for S1 and for S2 - lower shell, and combine them
    to get an answer.
    If the current triple of points does not form a right turn (which is easily verified
    by the oriented area ), the nearest neighbor to remove from the shell. Eventually a
    point will be only included in the convex hull.

    Thus, the algorithm is to sort all points along the abscissa and two (in the worst case)
    all rounds points, i.e. required asymptotic behavior of O (N log N) is reached.

    Algorithm return counterclockwise UP vector of Points and clockwise DOWN vector of Points
    So in the buildHull method the picture of p1, p, and p2 is
                 p                  Figure show upper set of convex hull.
               /  \                 p1 is first and p2 is at last, so for upper set it should be
             p1    p2               clockwise for p1, p, p2 and for lower set it must be anticlockwise

    Can be used to find "Farthest Pair Points"
*/
class Point implements Comparable<Point>{
    public double x,y;
    public Point(double xc, double yc){
        this.x = xc;
        this.y = yc;
    }
    public int compareTo(Point that){
        if(this.x < that.x) return -1;
        else if(this.x == that.x && this.y < that.y) return -1;
        else if(this.x == that.x && this.y == that.y) return 0;
        else return 1;
    }
    public static boolean clockwise(Point p1, Point p2, Point p3){
        return p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y) < 0;
    }
    public static boolean counterclockwise(Point p1, Point p2, Point p3){
        return p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y) > 0;
    }
}
public class ConvexHull {

    List<Point> pv;
    List<Point> up = new Vector<Point>();
    List<Point> down = new Vector<Point>();
    public ConvexHull(Vector<Point> v){
        this.pv = v;
        Collections.sort(pv);
        buildHull();
    }
    public void buildHull(){
        Point p1, p2;
        p1 = pv.get(0); /* the first point */
        p2 = pv.get(pv.size() - 1); /* last point */
        up.add(p1);     /* first point will be in both */
        down.add(p1);
        for (int i = 0; i < pv.size(); i++) {
            Point p = pv.get(i);
            /* if p1 (first point), p (current point), p2 (last point), makes a clockwise
                turn, then we will have to add p to the up vector,
                since we have added p, now the previous added point pp = up.get(size() - 1)
                makes a anticlockwise turn with the new added point p and point before it,
                we have to remove it.
                This goes for every point added in the vector up previously.
                At last add p.
                Same goes for down vector.
            */
            if(i == pv.size() - 1 || Point.clockwise(p1, p, p2)){
                while (up.size() >= 2 && !Point.clockwise(up.get(up.size() - 2), up.get(up.size() - 1), p))
                    up.remove(up.size() - 1);
                up.add(p);
            }
            if(i == pv.size() - 1 || Point.counterclockwise(p1, p, p2)){
                while(down.size() >= 2 && !Point.counterclockwise(down.get(down.size() - 2),down.get(down.size() - 1),p))
                    down.remove(down.size() - 1);
                down.add(p);
            }
        }
        pv.clear();
        for (Point point : up) {
            pv.add(point);
        }
        for (Point point : down) {
            pv.add(point);
        }
    }
    public List<Point> retUp(){
        return up;
    }
    public List<Point> retDown(){
        return down;
    }
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(in.readLine());
            Vector<Point> pvec = new Vector<Point>();
            for(int t = 0; t < n; t++)
            {
                String sar[] = (in.readLine()).split(" ");
                Point p = new Point(Double.parseDouble(sar[0]),Double.parseDouble(sar[1]));
                pvec.add(p);
            }
            ConvexHull ch = new ConvexHull(pvec);
            List<Point> ans = ch.retUp();
            Iterator<Point> it = ans.iterator();
            while(it.hasNext())
            {
                Point ap = it.next();
                System.out.println(ap.x+" "+ap.y);
            }
            System.out.println("end up");
            ans = ch.retDown();
            it = ans.iterator();
            while(it.hasNext())
            {
                Point ap = it.next();
                System.out.println(ap.x+" "+ap.y);
            }
            out.newLine();
            in.close();
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
