package gcj2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author  tasyrkin
 * @since   2014/04/12
 */
public class MinesweeperMaster {

    private static class Pair {
        int x, y;

        Pair(final int ix, final int iy) {
            x = ix;
            y = iy;
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(br.readLine());
        int init = t;
        while (t-- > 0) {
            String[] parts = br.readLine().split("\\s+");
            int R = Integer.parseInt(parts[0]);
            int C = Integer.parseInt(parts[1]);
            int M = Integer.parseInt(parts[2]);

            char[][] r = new char[R][C];
            int[][] ri = new int[R][C];
            for (int i = 0; i < r.length; i++) {
                Arrays.fill(r[i], '*');
                Arrays.fill(ri[i], -1);
            }

            r[0][0] = 'c';

            Queue<Pair> q = new LinkedList<Pair>();
            q.add(new Pair(0, 0));

            int E = R * C - M - 1;
            while (!q.isEmpty() && E > 0) {
                Pair p = q.poll();
                if (r[p.x][p.y] == '*') {
                    r[p.x][p.y] = '.';
                    if (--E == 0) {
                        break;
                    }
                }

                if (isValid(p.x + 1, p.y, R, C)) {
                    q.add(new Pair(p.x + 1, p.y));
                }

                if (isValid(p.x, p.y + 1, R, C)) {
                    q.add(new Pair(p.x, p.y + 1));
                }

                if (isValid(p.x + 1, p.y + 1, R, C)) {
                    q.add(new Pair(p.x + 1, p.y + 1));
                }
            }

            printMatrix(R, C, r);

            Queue<Pair> qi = new LinkedList<Pair>();
            qi.add(new Pair(0, 0));
            while (!qi.isEmpty()) {
                Pair p = qi.poll();
                if (r[p.x][p.y] == '*') {
                    continue;
                }

                int cntStar = 0;
                for (int i = p.x - 1; i <= p.x + 1; i++) {
                    for (int j = p.y - 1; j <= p.y + 1; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }

                        if (isValid(i, j, R, C)) {
                            if (r[i][j] == '*') {
                                cntStar++;
                            }
                        }
                    }
                }

                ri[p.x][p.y] = cntStar;
                if (cntStar == 0) {
                    for (int i = p.x - 1; i <= p.x + 1; i++) {
                        for (int j = p.y - 1; j <= p.y + 1; j++) {
                            if (i == 0 && j == 0) {
                                continue;
                            }

                            if (isValid(i, j, R, C)) {
                                if (ri[i][j] == -1) {
                                    qi.add(new Pair(i, j));
                                }
                            }
                        }
                    }
                }
            }

            boolean isPossible = true;
            main:
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (ri[i][j] == -1 && r[i][j] != '*') {
                        isPossible = false;
                        break main;
                    }
                }

            }

            System.out.print("Case #" + (init - t) + ":");
            if (!isPossible) {
                System.out.println("Impossible");
            } else {
                System.out.println("");

                printMatrix(R, C, r);
            }

        }

    }

    private static void printMatrix(final int R, final int C, final char[][] r) {
        for (int i = 0; i < R; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < C; j++) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }

                sb.append(r[i][j]);
            }

            System.out.println(sb.toString());
        }
    }

    private static boolean isValid(final int x, final int y, final int r, final int c) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}
