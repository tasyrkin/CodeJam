package gcj2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Wrong solution
 */
public class TidyNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();

            long result = solve(String.valueOf(N).length() - 1);


            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static long solve(final int N) {

        if (N == 0) return 0;
        if (N == 1) return 9;

        final long S[][] = new long[N + 1][10];
        for (int i = 1; i <= 9; i++) {
            S[1][i] = 1;
        }

        for (int numLength = 2; numLength <= N; numLength++) {
            for (int newLastDigit = 1; newLastDigit <= 9; newLastDigit++) {
                for (int prevLastDigit = newLastDigit; prevLastDigit <= 9; prevLastDigit++) {
                    S[numLength][newLastDigit] += S[numLength - 1][prevLastDigit];
                }
            }
        }

        long result = 0;
        for (int i = 1; i <= 9; i++) {
            result += S[N][i];
        }

        return result;
    }
}
