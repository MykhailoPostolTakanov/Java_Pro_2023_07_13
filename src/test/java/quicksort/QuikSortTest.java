package quicksort;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QuikSortTest {

    @Test
    void quikSort() {
        int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        QuikSort.quikSort(array, 0, array.length);
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < array.length; i++)
            assertEquals(expected[i], array[i]);
    }

    @Test
    void quikSortWithRandom() {
        Random random = new Random();
        int[] array = random.ints(500_000, 10, 100).toArray();
        QuikSort.quikSort(array, 0, array.length);
        for (int i = 0; i < array.length - 1; i++) {
            boolean result = array[i] <= array[i + 1];
            assertTrue(result);
        }
    }
}