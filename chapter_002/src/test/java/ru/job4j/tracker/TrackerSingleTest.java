package ru.job4j.tracker;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TrackerSingleTest {

    @Test
    public void singleTestOneLazyloading() {
       Tracker tracker1 = TrackerSingle.getInstance();
       Tracker tracker2 = TrackerSingle.getInstance();
        assertThat(tracker2, is(tracker1));
    }

    @Test
    public void singleTestTwoEagerloading() {
        Tracker tracker1 = TrackerSingleTwo.getInstance();
        Tracker tracker2 = TrackerSingleTwo.getInstance();
        assertThat(tracker2, is(tracker1));
    }

    @Test
    public void singleTestThreeLazeloading() {
        Tracker tracker1 = TrackerSingleThree.getInstance();
        Tracker tracker2 = TrackerSingleThree.getInstance();
        assertThat(tracker2, is(tracker1));
    }

    @Test
    public void singleTestEnumEagerloading() {
        TrackerSingleEnum tracker1 = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum tracker2 = TrackerSingleEnum.INSTANCE;
        assertThat(tracker2, is(tracker1));
    }
}
