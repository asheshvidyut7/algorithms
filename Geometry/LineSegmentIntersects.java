package Geometry;

import java.awt.*;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    Given two line segments, find whether they intersect or not.
    Also finding if Point is inside the Polygon or not is also given on Geeks For Geeks
    Orientation of Points can be . counterclockwise, clockwise, collinear. For that
    we have to use the area of triangle which is (det(x1 y1 1))/2
                                                     x2 y2 1
                                                     x3 y3 1
    if this area if positive then orientation is counter clockwise.
    if the area is negative then the orientation is clockwise.
    Two segments (p1,q1) and (p2,q2) intersect if and only if one of the following two
    conditions is verified
    1. General Case:
        - (p1, q1, p2) and (p1, q1, q2) have different orientations and
        - (p2, q2, p1) and (p2, q2, q1) have different orientations

    2. Special Case
        - (p1, q1, p2), (p1, q1, q2), (p2, q2, p1), and (p2, q2, q1) are all collinear and
        - the x-projections of (p1, q1) and (p2, q2) intersect
        - the y-projections of (p1, q1) and (p2, q2) intersect

 */
public class LineSegmentIntersects {
    /* Given three colinear points p, q, r, the function checks if point q lies on line segment 'pr' */
    int orientation(Point p, Point q, Point r){
        int val = (int) ((double) (q.getY() - p.getY()) * (r.getX() - q.getX()) - (q.getX() - p.getX()) * (r.getY() - q.getY()));
        if (val == 0 ) return 0;
        if(val < 0) return -1;
        else return 1;
    }
    public boolean onSegment(Point p, Point q, Point r){
        if (q.getX() <= Math.max(p.getX(), r.getX()) && q.getX() >= Math.min(p.getX(), r.getX()) &&
                q.getX() <= Math.max(p.getY(), r.getY()) && q.getY() >= Math.min(p.getY(), r.getY()))
            return true;
        return false;
    }
    public boolean intersects(Point p1, Point q1, Point p2, Point q2){
        /* Find the four orientations needed for general and special cases */
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);
        /* General case */
        if (o1 != o2 && o3 != o4)
            return true;
        /* Special Cases */
        /* p1, q1 and p2 are colinear and p2 lies on segment p1q1 */
        if (o1 == 0 && onSegment(p1, p2, q1)) return true;

        /* p1, q1 and p2 are colinear and q2 lies on segment p1q1 */
        if (o2 == 0 && onSegment(p1, q2, q1)) return true;

        /* p2, q2 and p1 are colinear and p1 lies on segment p2q2 */
        if (o3 == 0 && onSegment(p2, p1, q2)) return true;

        /* p2, q2 and q1 are colinear and q1 lies on segment p2q2 */
        if (o4 == 0 && onSegment(p2, q1, q2)) return true;

        return false;
    }
    public static void main(String[] args) {
        try {
             Point p1 = new Point(10, 0);
             Point q1 = new Point(0, 10);
             Point p2 = new Point(0, 0);
             Point q2 = new Point(10, 10);
             LineSegmentIntersects i = new LineSegmentIntersects();
             System.out.println(i.intersects(p1, q1, p2, q2));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
