package gcj2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pogo {

    public static class Pair {
        int idx;
        int step;
        String steps;

        public Pair(final int i, final int s, final String ss) {
            this.idx = i;
            step = s;
            steps = ss;
        }
    }

    public static void main(final String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(br.readLine());
        int init = t;
        while (t-- > 0) {
            String[] parts = br.readLine().split("\\s+");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);

            String res = "";
            if (x > 0) {
                if (x == 1) {
                    res = "E";
                } else {
                    for (int i = 0; i < x - 1; i++) {
                        res += "EW";
                    }

                    res += "E";
                }
            } else if (x < 0) {
                if (x == -1) {
                    res = "W";
                } else {
                    for (int i = 0; i < -x - 1; i++) {
                        res += "WE";
                    }

                    res += "W";
                }
            }

            if (y > 0) {
                for (int i = 0; i < y; i++) {
                    res += "SN";
                }
            } else if (y < 0) {
                for (int i = 0; i < -y; i++) {
                    res += "NS";
                }
            }

            System.out.println("Case #" + (init - t) + ": " + res);
        }
    }
}
