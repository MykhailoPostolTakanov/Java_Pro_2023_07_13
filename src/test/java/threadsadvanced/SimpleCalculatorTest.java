package threadsadvanced;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    @Test
    void squareSum() throws ExecutionException, InterruptedException {
        int result = SimpleCalculator.squareSum(5, 4);
        int expected = 41;
        assertEquals(expected, result);
    }
}