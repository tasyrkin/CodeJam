package gcj2014;

import java.util.Arrays;

/**
 * @author  tasyrkin
 * @since   2014/04/12
 */
public class EllysSortingTrimmer {
    public String getMin(String S, final int L) {

        for (int i = S.length() - L; i >= 0; i--) {
            char[] ch = S.substring(i, i + L).toCharArray();
            Arrays.sort(ch);
            S = S.substring(0, i) + new String(ch);

        }

        return S;
    }

    public static void main(final String[] args) {
        EllysSortingTrimmer s = new EllysSortingTrimmer();

        String res = s.getMin("ABRACADABRA", 5);
        System.out.println(res);
    }
}
