package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
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