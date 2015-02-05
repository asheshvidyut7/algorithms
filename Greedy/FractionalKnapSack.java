package Greedy;

import Backtracking.RatMaze;

import java.util.Arrays;

/**
 * Ashesh Vidyut (Drift King) *
 */
class RatioWeight implements Comparable<RatioWeight>{
    double ratio;
    double weight;
    public RatioWeight(double r, double w){
        this.ratio = r;
        this.weight = w;
    }
    public int compareTo(RatioWeight that){
        if(this.ratio > that.ratio){
            return -1;
        }
        else if(this.ratio < that.ratio){
            return 1;
        }
        else
            return 0;
    }
}
public class FractionalKnapSack {
    public double fracKanpSack(double profit[], double weight[], double W){
        double ratio[] = new double[profit.length];
        RatioWeight ar[] = new RatioWeight[profit.length];
        for (int i = 0; i < profit.length; i++) {
            ratio [i] = profit[i] / weight[i];
            ar[i] = new RatioWeight(ratio[i], weight[i]);
        }
        Arrays.sort(ar);
        double ans = 0;
        double weight_left = W;
        for (int i = 0; i < ar.length; i++) {
            RatioWeight rw = ar[i];
            if(rw.weight <= weight_left){
                ans += (rw.ratio * rw.weight);
                weight_left -= rw.weight;
            }
            else{
                ans += weight_left * ratio[i];
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        try {
            FractionalKnapSack f = new FractionalKnapSack();
            double w[] = {12.0, 1.0, 2.0, 1.0, 4.0};
            double p[] = {4.0, 2.0, 2.0, 1.0, 10.0};
            double W = 15;
            System.out.println(f.fracKanpSack(p, w , W));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
