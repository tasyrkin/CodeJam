import java.util.Arrays;

/**
 * @author  tasyrkin
 * @since   2014/05/09
 */
public class SegmentTree {

    public static void main(final String[] args) {

        int[] a = {2, 5, 12, 6, 7, 12, 2, 4};

        int n = a.length;

        int[] ST = new int[4 * n];

        build(ST, a, 1, 0, n - 1);

        System.out.println(Arrays.toString(ST));

        int sum = search(ST, 1, 0, n - 1, 1, n - 1);
        System.out.println("sum = " + sum);

    }

    private static int search(final int[] ST, final int vertex, final int left, final int right, final int rq_left,
            final int rq_right) {
        if (rq_left > rq_right) {
            return 0;
        } else if (left == rq_left && right == rq_right) {
            return ST[vertex];
        } else {
            int mid = left + (right - left) / 2;
            int res_left = search(ST, 2 * vertex, left, mid, rq_left, Math.min(mid, rq_right));
            int res_right = search(ST, 2 * vertex + 1, mid + 1, right, Math.max(mid + 1, rq_left), rq_right);
            return res_left + res_right;
        }
    }

    private static void build(final int[] ST, final int[] orig, final int vertex, final int left, final int right) {
        if (left == right) {
            ST[vertex] = orig[left];
        } else {
            int mid = (left + right) / 2;
            build(ST, orig, 2 * vertex, left, mid);
            build(ST, orig, 2 * vertex + 1, mid + 1, right);
            ST[vertex] = ST[2 * vertex] + ST[2 * vertex + 1]; // function
        }
    }

}
