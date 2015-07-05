
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author  tasyrkin
 * @since   2014/04/12
 */
public class TrainCars {

    private static int cnt;
    private static Set<String> stringSet = new HashSet<String>();

    private static class MyString {
        int num;
        String s;

        public MyString(final int n, final String str) {
            num = n;
            s = str;
        }

        public String toString() {
            return num + s;
        }
    }

    private static String toString(final LinkedList<MySet> sets) {
        StringBuilder sb = new StringBuilder();
        for (MySet s : sets) {
            sb.append(s.toString());
        }

        return sb.toString();
    }

    private static class MySet {
        LinkedList<MyString> sets = new LinkedList<MyString>();

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (MyString s : sets) {
                sb.append(s);
            }

            return sb.toString();
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(br.readLine());
        int init = t;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] parts = br.readLine().split("\\s+");
            cnt = 0;
            stringSet = new HashSet<String>();

            MyString[] myParts = new MyString[n];
            for (int i = 0; i < n; i++) {
                myParts[i] = new MyString(i, parts[i]);
            }

            Set<Integer> visited = new HashSet<Integer>();
            LinkedList<MySet> formedSets = new LinkedList<MySet>();
            for (int i = 0; i < n; i++) {
                visited.add(i);

                MySet s = new MySet();
                s.sets.add(myParts[i]);
                formedSets.add(s);
                solve(myParts, i, visited, formedSets);
                visited.remove(Integer.valueOf(i));
            }

            System.out.println("Case #" + (init - t) + ": " + cnt);
        }

    }

    private static void solve(final MyString[] parts, final int curr, final Set<Integer> visited,
            final LinkedList<MySet> formedSets) {
        boolean foundOnce = false;
        for (int i = 0; i < parts.length; i++) {
            if (visited.contains(i)) {
                continue;
            }

            MySet s = formedSets.getLast();
            MyString str = s.sets.getLast();
            if (str.s.charAt(str.s.length() - 1) == parts[i].s.charAt(0)) {
                foundOnce = true;
                s.sets.add(parts[i]);
                visited.add(i);
                solve(parts, curr, visited, formedSets);
                visited.remove(Integer.valueOf(i));
                s.sets.removeLast();
            }
        }

        if (!foundOnce) {
            boolean foundAnother = false;
            for (int i = 0; i < parts.length; i++) {
                if (!visited.contains(i)) {
                    foundAnother = true;
                    visited.add(i);

                    MySet s = new MySet();
                    s.sets.add(parts[i]);
                    formedSets.add(s);
                    solve(parts, curr, visited, formedSets);
                    formedSets.removeLast();
                    visited.remove(Integer.valueOf(i));
                }
            }

            if (!foundAnother) {
                int l = 0;

                for (MySet s : formedSets) {
                    for (MyString str : s.sets) {
                        l += str.s.length();
                    }
                }

                char[] a = new char[l];
                int st = 0;
                for (MySet s : formedSets) {
                    for (MyString str : s.sets) {
                        char[] arr = str.s.toCharArray();
                        for (int i = 0; i < str.s.toCharArray().length; i++) {
                            a[st + i] = arr[i];
                        }

                        st += str.s.length();
                    }

                }

                int[] chs = new int[256];
                boolean ok = true;
                chs[a[0]]++;
                for (int i = 1; i < a.length; i++) {
                    if (a[i] != a[i - 1]) {
                        if (chs[a[i]] > 0) {
                            ok = false;
                            break;
                        }
                    }

                    chs[a[i]]++;
                }

                if (ok) {
                    String hash = TrainCars.toString(formedSets);
                    System.out.println(hash);
                    if (!stringSet.contains(hash)) {
                        stringSet.add(hash);
                        cnt++;
                    }
                }
            }
        }
    }

}
