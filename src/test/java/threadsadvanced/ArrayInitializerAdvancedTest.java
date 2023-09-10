package threadsadvanced;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import static org.junit.jupiter.api.Assertions.*;

class ArrayInitializerAdvancedTest {

    @Test
    void init() {
        double a = Math.random();
        double[] array = new double[220];
        Arrays.fill(array, a);
        ArrayInitializerAdvanced arrayInitializerAdvanced = new ArrayInitializerAdvanced(array);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        double[] result = forkJoinPool.invoke(arrayInitializerAdvanced);
        for (int i = 0; i < result.length / 2; i++) {
            assertEquals(result[i], result[result.length / 2 + i]);
        }
    }
}