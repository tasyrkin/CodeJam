package gcj2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.Set;

public class Consonants {

    public static void main(final String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(br.readLine());
        int init = t;
        while (t-- > 0) {
            String[] parts = br.readLine().split("\\s+");
            char[] s = parts[0].toCharArray();
            int n = Integer.parseInt(parts[1]);

            Set<Character> vow = new HashSet<Character>();
            vow.add('a');
            vow.add('e');
            vow.add('i');
            vow.add('o');
            vow.add('u');

            Set<String> res = new HashSet<String>();

            long cnt = 0;
            int start = -1;
            for (int i = 0; i < s.length; i++) {
                if (start == -1) {
                    if (!vow.contains(s[i])) {
                        start = i;
                    }
                } else {
                    if (!vow.contains(s[i])) {
                        if (i - start + 1 == n) {
                            long numBefore = start;
                            long numAfter = s.length - (i + 1);

                            for (int bef = start; bef >= 0; bef--) {
                                for (int aft = i; aft < s.length; aft++) {
                                    res.add(bef + "," + aft);
                                }
                            }

                            // cnt += numBefore + numBefore * numAfter + numAfter + 1;
                            ++start;

                        }
                    } else {
                        start = -1;
                    }
                }
            }

            System.out.println("Case #" + (init - t) + ": " + res.size());
        }
    }
}
