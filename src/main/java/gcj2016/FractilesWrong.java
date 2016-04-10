package gcj2016;

import java.util.Scanner;

/*
Wrong solution
*/
public class FractilesWrong {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {

            int K = scanner.nextInt();
            int C = scanner.nextInt();
            int S = scanner.nextInt();

            if(C == 1){
                if(S != K) {
                    System.out.println(String.format("Case #%d: IMPOSSIBLE", caseNumber));
                } else {
                    final StringBuilder sb = new StringBuilder();
                    int currentPos = 1;
                    sb.append(currentPos);
                    for(currentPos = 2; currentPos <= K; currentPos++){
                        sb.append(" ");
                        sb.append(currentPos);
                    }
                    System.out.println(String.format("Case #%d: %s", caseNumber, sb.toString()));
                }
            } else {
                if(K/2 + (K%2 != 0 ? 1 : 0) > S){
                    System.out.println(String.format("Case #%d: IMPOSSIBLE", caseNumber));
                } else {
                    long dist = 1;
                    for(int i = 0; i < C-1; i++){
                        dist *= K;
                    }

                    StringBuilder sb = new StringBuilder();

                    long blockStart = 0;
                    int tileToCheck = 1;

                    for(int i = 0; i < K/2; i++){
                        if(sb.length() != 0)sb.append(" ");
                        sb.append(blockStart + tileToCheck + 1);
                        blockStart += 2 * dist;
                        tileToCheck += 2;
                    }

                    if(K % 2 != 0){
                        if(sb.length() != 0)sb.append(" ");
                        sb.append(blockStart + dist);
                    }

                    System.out.println(String.format("Case #%d: %s", caseNumber, sb.toString()));

                }
            }
        }
    }
}
