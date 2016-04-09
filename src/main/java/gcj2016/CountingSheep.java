package gcj2016;

import java.util.Scanner;

public class CountingSheep {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while(caseNumber++ < T) {

            final int N = scanner.nextInt();
            if(N == 0){
                System.out.println(String.format("Case #%d: %s", caseNumber, "INSOMNIA"));
                continue;
            }
            boolean[] found = new boolean[10];

            int currentN = N;

            while(!allFound(found)){
                int num = currentN;
                while(num > 0){
                    found[num % 10] = true;
                    num /= 10;
                }
                currentN += N;
            }

            System.out.println(String.format("Case #%d: %s", caseNumber, currentN-N));
        }

    }

    private static boolean allFound(boolean[] found) {
        for(boolean flag : found){
            if(!flag)return false;
        }
        return true;
    }
}
