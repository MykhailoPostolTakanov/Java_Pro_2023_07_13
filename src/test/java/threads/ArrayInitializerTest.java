package threads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayInitializerTest {

    @Test
    void init() throws InterruptedException {
        double a = Math.random();
        double[] array = {a, a, a, a, a, a, a, a, a, a};
        ArrayInitializer.init(array);
        double[] arr = ArrayInitializer.getArr();
        for (int i = 0; i < arr.length / 2; i++) {
            assertEquals(arr[i], arr[arr.length / 2 + i]);
        }
    }
}