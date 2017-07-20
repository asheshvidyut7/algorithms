package GeeksForGeeks;

import IO.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 18/07/17
 **/
public class ParenthesisChecker {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                boolean ans = true;
                char s[] = in.readLine().toCharArray();
                Stack<Character> st = new Stack<>();
                for (int i = 0; i < s.length; i++) {
                    if (s[i] == '[' || s[i] == '{' || s[i] == '(') {
                        st.push(s[i]);
                    }
                    else {
                        if (st.size() == 0) {
                            ans = false;
                            break;
                        }
                        if (st.peek() == '(' && s[i] == ')') {
                            st.pop();
                        }
                        else if (st.peek() == '{' && s[i] == '}') {
                            st.pop();
                        }
                        else if (st.peek() == '[' && s[i] == ']') {
                            st.pop();
                        }
                        else {
                            ans = false;  break;
                        }
                    }
                }
                if (st.size() != 0) {
                    ans = false;
                }
                if (ans) {
                    out.write("balanced");
                }
                else {
                    out.write("not balanced");
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
