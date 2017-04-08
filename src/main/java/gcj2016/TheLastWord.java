package gcj2016;

import java.util.Scanner;

public class TheLastWord {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {

            char[] chs = scanner.next().toCharArray();

            String last = "";

            for (int i = 0; i < chs.length; i++) {
                if(last.length() == 0){
                    last = String.valueOf(chs[i]);
                } else {
                    if(last.charAt(0) <= chs[i]){
                        last = chs[i] + last;
                    } else {
                        last = last + chs[i];
                    }
                }
            }

            System.out.println(String.format("Case #%d: %s", caseNumber, last));
        }
    }
}
