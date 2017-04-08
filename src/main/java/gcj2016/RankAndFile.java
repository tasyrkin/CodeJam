package gcj2016;

import java.util.Arrays;
import java.util.Scanner;

public class RankAndFile {

    private static class MyRow implements Comparable<MyRow>{

        final int[]array;

        private MyRow(int[] array) {
            this.array = array;
        }

        @Override
        public int compareTo(MyRow o) {
            return this.toString().compareTo(o.toString());
        }

        @Override
        public String toString() {
            return Arrays.toString(array);
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {

            int N = scanner.nextInt();
            MyRow[] rows = new MyRow[2*N-1];

            for (int i = 0; i < rows.length; i++) {
                int[]arr = new int[N];
                for (int j = 0; j < N; j++) {
                    arr[j] = scanner.nextInt();
                }
                rows[i] = new MyRow(arr);
            }

            Arrays.sort(rows);

            int[][]result = new int[N][N];

            result[0] = rows[0].array;

            int i = 0;
            int j = 0;
            for (int step = 0; step < 2*N-1; step++) {
                if(result[i][0] != 0 && result[i][0] == rows[step].array[0]){
                    result[i] = rows[step].array;
                    i++;
                } else if (result[0][j] != 0 && result[0][j] == rows[step].array[0]){
                    //copy
                    for (int k = 0; k < N; k++) {
                        result[k][j] = rows[step].array[k];
                    }
                    j++;
                } else if(result[i][0] == 0){
                    result[i] = rows[step].array;
                    i++;
                } else {
                    for (int k = 0; k < N; k++) {
                        result[k][j] = rows[step].array[k];
                    }
                    j++;
                }
            }


            //System.out.println(String.format("Case #%d: %s", caseNumber, last));
        }
    }
}
