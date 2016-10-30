package br.com.vs.templatemethod;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class IntBubbleSorterTest {
    @Test
    public void sortIntArray() {
        int[] array = {2, 1, 12, 21, 3, 15, 2, 25, 20, 14, 13, 0, 5};
        int[] sortedArray = {0, 1, 2, 2, 3, 5, 12, 13, 14, 15, 20, 21, 25};

        IntBubbleSorter sorter = new IntBubbleSorter();
        sorter.sort(array);

        assertArrayEquals(array, sortedArray);
    }
}