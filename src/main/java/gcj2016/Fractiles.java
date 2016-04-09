package gcj2016;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.Scanner;

public class Fractiles {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {

            int K = scanner.nextInt();
            int C = scanner.nextInt();
            int S = scanner.nextInt();

            long dist = 1;
            for(int i = 0; i < C-1; i++){
                dist *= K;
            }

            StringBuilder sb = new StringBuilder();

            long currentPos = 1;
            sb.append(currentPos);

            for(int i = 1; i < K; i++){
                currentPos += dist;
                sb.append(" ");
                sb.append(currentPos);
            }

            System.out.println(String.format("Case #%d: %s", caseNumber, sb.toString()));
        }
    }
}
