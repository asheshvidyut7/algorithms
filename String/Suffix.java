package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
<<<<<<< HEAD
 *
=======
 * Ashesh Vidyut (Drift King) *
>>>>>>> c6aee27e327e96a58c4583ac08325c3bed0bb43f
 */
public class Suffix implements Comparable<Suffix>{
    public int ind;
    public String string;
    public int len;
    public Suffix(String s, int i){
        this.ind = i;
        this.string = s.substring(i);
        this.len = s.length() - i;
    }
    public int compareTo(Suffix that){
        return this.string.compareTo(that.string);
    }
}