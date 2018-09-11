package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир", "Привет"};
        String[] result = duplicate.remove(input);
        String[] expect = {"Привет", "Супер", "Мир"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
