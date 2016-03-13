package gcj2011;

import static gcj2011.SpaceEmergency201603.findOptimalTime;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SpaceEmergency201603Test {

    @org.junit.Test
    public void testFindOptimalTime() throws Exception {
        assertThat(findOptimalTime(2, 20, 8, 2, new int[]{3, 5}), is(54L));
        assertThat(findOptimalTime(1, 4, 2, 2, new int[]{10, 4}), is(20L));
        assertThat(findOptimalTime(2, 4, 4, 3, new int[]{4, 5, 10}), is(31L));
        assertThat(findOptimalTime(2, 4, 4, 3, new int[]{2, 5, 10}), is(23L));
        assertThat(findOptimalTime(1, 0, 10, 10, new int[]{9995, 4, 9, 3, 3, 6, 5, 3, 2, 9}), is(10083L));
    }
}