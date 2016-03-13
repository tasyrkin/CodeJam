package gcj2010;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import static gcj2010.ElegantDiamond.findMinExpansion;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ElegantDiamondTest {

    @Test
    public void testFindMinExpansion() throws Exception {
        assertThat(findMinExpansion(new int[]{1}), is(0));
        assertThat(findMinExpansion(new int[]{1, 1}), is(0));
        assertThat(findMinExpansion(new int[]{1, 2}), is(1));
        assertThat(findMinExpansion(new int[]{1, 1, 3}), is(1));
        assertThat(findMinExpansion(new int[]{1, 2, 3}), is(2));
        assertThat(findMinExpansion(new int[]{1, 2, 2}), is(1));
        assertThat(findMinExpansion(new int[]{1, 2, 3, 4}), is(3));
        assertThat(findMinExpansion(new int[]{1, 2, 3, 2}), is(1));
        assertThat(findMinExpansion(new int[]{1, 2, 3, 4, 5}), is(4));
        assertThat(findMinExpansion(new int[]{1, 2, 3, 4, 1}), is(4));
    }
}