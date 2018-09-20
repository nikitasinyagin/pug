package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortThreeTest {

    @Test
    public void inFirstInSecondOutThree() {
        BubbleSortThree bubbleSortThree = new BubbleSortThree();
        int[] inputFirst = new int[]{1, 3, 4, 5, 7};
        int[] inputSecond = new int[]{1, 2, 9};
        int[] result = bubbleSortThree.sort(inputFirst, inputSecond);
        int[] expect = new int[]{1, 1, 2, 3, 4, 5, 7, 9};
        assertThat(result, is(expect));
    }
}
