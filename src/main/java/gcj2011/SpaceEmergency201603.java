package gcj2011;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * This does not solve the B-small problem :/
 */
public class SpaceEmergency201603 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while(caseNumber++ < T) {
            final int L = scanner.nextInt();
            final long t = scanner.nextLong();
            final int N = scanner.nextInt();
            final int C = scanner.nextInt();
            int[]as = new int[C];
            for(int i = 0; i < as.length; i++) {
                as[i] = scanner.nextInt();
            }
            long timeNoBoosters = 0;
            boolean timeElapsed = false;
            final LinkedList<Long> remainingDistances = new LinkedList<>();
            for(int star = 0; star < N; star++) {
                long nextTime = timeNoBoosters + 2 * as[star % C];

                if(timeElapsed) {
                    remainingDistances.add((long)as[star % C]);
                }

                if(nextTime >= t && t >= timeNoBoosters) {
                    timeElapsed = true;
                    long remainingDistance = (nextTime - t) / 2;
                    remainingDistances.add(remainingDistance);
                }

                timeNoBoosters = nextTime;
            }

            final Long[] remainingDistancesArr = remainingDistances.toArray(new Long[0]);
            Arrays.sort(remainingDistancesArr);

            long optimalTime = Math.min(timeNoBoosters, t);

            int booster;

            for(booster = 0; booster < L && remainingDistancesArr.length - 1 - booster >= 0; booster++) {
                optimalTime += remainingDistancesArr[remainingDistancesArr.length - 1 - booster];
            }

            for(int distances = booster; distances < remainingDistancesArr.length && remainingDistancesArr.length - 1 - distances >= 0; distances++) {
                optimalTime += 2 * remainingDistancesArr[remainingDistancesArr.length - 1 - distances];
            }

            System.out.println(String.format("Case #%d: %d", caseNumber, optimalTime));
        }
    }
}
