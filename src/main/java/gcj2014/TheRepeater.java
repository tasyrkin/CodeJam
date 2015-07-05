package gcj2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  tasyrkin
 * @since   2014/04/12
 */
public class TheRepeater {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(br.readLine());
        int init = t;
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            String[] str = new String[n];
            List<Character> s = new ArrayList<Character>();
            boolean wonFelda = false;
            Map[] map = new HashMap[n];
            main:
            for (int i = 0; i < n; i++) {
                List<Character> s1 = new ArrayList<Character>();
                map[i] = new HashMap();
                str[i] = br.readLine();
                if (s.isEmpty()) {
                    char[] ch = str[i].toCharArray();
                    for (int j = 0; j < ch.length; j++) {
                        if (j == 0) {
                            map[i].put(ch[j], 1);
                            s.add(ch[j]);
                        } else {
                            if (ch[j] != s.get(s.size() - 1)) {
                                s.add(ch[j]);
                                map[i].put(ch[j], 1);
                            } else {
                                map[i].put(ch[j], (Integer) map[i].get(ch[j]) + 1);
                            }
                        }
                    }

                    continue;
                } else {
                    char[] ch = str[i].toCharArray();
                    for (int j = 0; j < ch.length; j++) {
                        if (j == 0) {
                            map[i].put(ch[j], 1);
                            s1.add(ch[j]);
                        } else {
                            if (ch[j] != s1.get(s1.size() - 1)) {
                                map[i].put(ch[j], 1);
                                s1.add(ch[j]);
                            } else {
                                map[i].put(ch[j], (Integer) map[i].get(ch[j]) + 1);
                            }
                        }
                    }
                }

                // System.out.println(s1.toString());
                if (s1.size() != s.size()) {
                    wonFelda = true;
                } else {
                    for (int j = 0; j < s.size(); j++) {
                        if (s.get(j) != s1.get(j)) {
                            wonFelda = true;
                        }
                    }
                }
            }

            // System.out.println(s.toString());

            if (wonFelda) {
                System.out.println("Case #" + (init - t) + ": Fegla Won");
            } else {
                int sum = 0;
                for (int i = 0; i < map[0].size(); i++) {
                    int min = Integer.MAX_VALUE;
                    for (int j = 1; j <= 100; j++) {
                        int curr = 0;
                        for (int k = 0; k < n; k++) {
                            curr += Math.abs(j - (Integer) map[k].get(s.get(i)));
                        }

                        if (min > curr) {
                            min = curr;
                        }
                    }

                    sum += min;
                }

                System.out.println("Case #" + (init - t) + ": " + sum);
            }
        }

    }

}
