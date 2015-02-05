package PatternMatching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    The KMP matching algorithm uses degenerating property (pattern having same sub-patterns appearing
    more than once in the pattern) of the pattern and improves the worst case complexity to O(n).

    The basic idea behind KMP’s algorithm is: whenever we detect a mismatch (after some matches),
    we already know some of the characters in the text (since they matched the pattern characters
    prior to the mismatch). We take advantage of this information to avoid matching the characters
    that we know will anyway match.

    KMP algorithm does some pre processing over the pattern pat[] and constructs an auxiliary array lps[]
    of size m (same as size of pattern).
    Here name lps indicates longest proper prefix which is also suffix..
    For each sub-pattern pat[0…i] where i = 0 to m-1, lps[i] stores length of the maximum matching proper
    prefix which is also a suffix of the sub-pattern pat[0..i].

    lps[i] = the longest proper prefix of pat[0..i]
                which is also a suffix of pat[0..i].

    Searching Algorithm:
    Unlike the Naive algo where we slide the pattern by one, we use a value from lps[] to
    decide the next sliding position. Let us see how we do that. When we compare pat[j] with txt[i]
    and see a mismatch, we know that characters pat[0..j-1] match with txt[i-j+1...i-1], and we also know
    that lps[j-1] characters of pat[0...j-1] are both proper prefix and suffix which means we do not need to
    match these lps[j-1] characters with txt[i-j...i-1] because we know that these characters will anyway match

    For the pattern “AABAACAABAA”, lps[] is [0, 1, 0, 1, 2, 0, 1, 2, 3, 4, 5]

    Uses of KMP -
    1.  Using KMP we can find the length of longest common prefix between pattern and substring of
        a given string.

 */
public class KMP {
    public static int[] prefixFunction(String s) {
        int[] p = new int[s.length()];
        p[0] = 0;
        int k = 0;
        for (int i = 1; i < s.length(); i++) {
            while (k > 0 && s.charAt(k) != s.charAt(i))
                k = p[k - 1];
            if (s.charAt(k) == s.charAt(i))
                ++k;
            p[i] = k;
        }
        return p;
    }
    public static int kmpMatcher(String s, String pattern) {
        int m = pattern.length();
        if (m == 0)
            return 0;
        int[] p = prefixFunction(pattern);
        for (int i = 0, k = 0; i < s.length(); i++)
            /*
            for every index i in string s we are trying to match the pattern
            if the pat[k] matches s[i], the we move forward with the shift with k++,
            and i++ (that is after breaking from the for loop, in the for loop),
            when there is mismatch we use prefix function to find the number of characters already
            matched, if we are at k index on pattern, which is p[k - 1], means already matched k - 1
            character and the kth is mismatch, new to continue matching without starting over,
            we check how many characters are already matched by till k - 1, we will start from
            k = pf[k - 1] index again match again
            */
            for (;; k = p[k - 1]) {
                if (pattern.charAt(k) == s.charAt(i)) {
                    if (++k == m)
                        // we have got the pattern at index i and the length of pattern is m
                        // so starting index of shift is i + 1 - m
                        return i + 1 - m;
                    break;
                }
                if (k == 0)
                    break;
            }
        return -1;
    }
    public static void main(String[] args) {
        int pos = kmpMatcher("00101", "010");
        System.out.println(1 == pos);
    }
}