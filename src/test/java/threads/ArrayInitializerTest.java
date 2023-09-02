package threads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayInitializerTest {

    @Test
    void init() {
        double a = Math.random();
        double[] array = {a, a, a, a, a, a, a, a, a, a};
        ArrayInitializer.init(array);
        for (int i = 0; i < array.length / 2; i++) {
            assertEquals(array[i], array[array.length / 2 + i]);
        }
    }
}