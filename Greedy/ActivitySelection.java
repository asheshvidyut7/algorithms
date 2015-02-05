package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Ashesh Vidyut (Drift King) *
 */
class Activity{
    public int st;
    public int et;
    public Activity(int s, int e){
        this.st = s;
        this.et = e;
    }
    public String toString(){
        return this.st+" "+this.et;
    }
}
class ActivitySorter implements Comparator<Activity>{
    public int compare(Activity a1, Activity a2){
        if(a1.et == a2.et){
            return 0;
        }
        else if(a1.et > a2.et){
            return 1;
        }
        else
            return -1;
    }
}
public class ActivitySelection {
    public void printActivities(Activity[] avr){
        PriorityQueue<Activity> pq = new PriorityQueue<Activity>(avr.length, new ActivitySorter());
        Collections.addAll(pq, avr);
        Activity prev = pq.poll();
        System.out.println(prev);
        while(!pq.isEmpty()){
            Activity cur = pq.poll();
            if(cur.st >= prev.et){
                System.out.println(cur);
                prev = cur;
            }
        }
    }
    public static void main(String[] args) {
        try {
            ActivitySelection as = new ActivitySelection();
            int s[] =  {1, 3, 0, 5, 8, 5};
            int f[] =  {2, 4, 6, 7, 9, 9};
            Activity[] ar = new Activity[s.length];
            for (int i = 0; i < s.length; i++) {
                Activity a = new Activity(s[i],f[i]);
                ar[i] = a;
            }
            as.printActivities(ar);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
