package gcj2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author  tasyrkin
 * @since   2014/04/12
 */
public class NewLotteryGame2 {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(br.readLine());
        int init = t;
        while (t-- > 0) {
            String[] ps = br.readLine().split("\\s+");
            int A = Integer.parseInt(ps[0]);
            int B = Integer.parseInt(ps[1]);
            int K = Integer.parseInt(ps[2]);

            int idxA = -1;
            int idxB = -1;
            for (int i = 0; i < 32; i++) {
                if (((A >> i) & 0x1) == 1) {
                    idxA = i;
                }

                if (((B >> i) & 0x1) == 1) {
                    idxB = i;
                }
            }

            for (int i = 0; i < K; i++) {

                for (int j = 0; j < 32; j++) {
                    if (((i >> j) & 0x1) == 0) { }
                }
            }

            // System.out.println("Case #" + (init - t) + ": " + (cnt));
        }

    }

}
