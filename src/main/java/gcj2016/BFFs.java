package gcj2016;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class BFFs {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {

            int N = scanner.nextInt();

            int[]bffs = new int[N];

            for (int i = 0; i < bffs.length; i++) {
                int friend = scanner.nextInt() - 1;
                bffs[i] = friend;
            }

            int maxCycleLen = -1;
            for (int i = 0; i < bffs.length; i++) {
                int cycleLen = dfs(i, bffs);
                if(maxCycleLen < cycleLen)maxCycleLen = cycleLen;
            }

            System.out.println(String.format("Case #%d: %s", caseNumber, maxCycleLen));
        }
    }

    private static int dfs(int i, int[] bffs) {
        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        int current = i;
        int count = 0;
        while(!visited.contains(current)) {
            list.add(current);
            visited.add(current);
            current = bffs[current];
            count++;
        }
        Integer last = list.get(list.size() - 1);
        if(bffs[last] == list.get(list.size() - 2) || bffs[last] == i) {
            return count;
        }

        return 2;
    }
}
