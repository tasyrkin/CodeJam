package gcj2014;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author  tasyrkin
 * @since   2014/04/12
 */
public class EllysScrabble {
    public String getMin(final String l, final int md) {
        char[] orig = l.toCharArray();
        char[] ch = l.toCharArray();
        Arrays.sort(ch);

        char[] newch = new char[ch.length];
        Arrays.fill(newch, (char) 0);

        Set<Integer> used = new HashSet<Integer>();
        for (char cchar : ch) {
            for (int i = 0; i < orig.length; i++) {
                if (used.contains(i)) {
                    continue;
                }

                if (orig[i] == cchar) {
                    used.add(i);
                    for (int j = i - md; j <= i + md; j++) {
                        if (j >= 0 && j < orig.length) {
                            if (newch[j] == (char) 0) {
                                newch[j] = cchar;
                                break;
                            }
                        }
                    }

                    break;
                }
            }
        }

        return new String(newch);
    }

    public static void main(final String[] args) {
        EllysScrabble e = new EllysScrabble();
        String r = e.getMin("TOPCODER", 3);
        System.out.println(r);
    }
}
