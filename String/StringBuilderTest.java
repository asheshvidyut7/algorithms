package String;
/**
 * Ashesh Vidyut (Drift King) *
 */
/*
    String object is immutable whereas StringBuffer/StringBuilder objects are mutable.
    String Builder is fastest and it should be used wherever String processing is required.
    It has all the methods the string class has and has an advantage */
    /** Time Complexity of concat of String is O(n) and append of StringBuilder is O(1) ***
    * For substring its opposite.
    * Wherever we have to reverse a string we will use StringBuilder only otherwise TLE
    * **//*
    Difference between the StringBuffer and StringBuilder is that StringBuilders methods are not
    thread safe(not Synchronised). StringBuilder is faster than StringBuffer.
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        try {
            String name = "A";
            StringBuilder sb = new StringBuilder();
            long st = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                sb.append(name);
            }
            long et = System.currentTimeMillis();
            System.out.println(et - st);
            String s = "";
            st = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                s.concat(name);
            }
            et = System.currentTimeMillis();
            System.out.println(et - st);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
