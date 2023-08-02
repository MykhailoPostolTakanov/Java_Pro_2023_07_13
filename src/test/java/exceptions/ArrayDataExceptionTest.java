package exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDataExceptionTest {
    @Test
    void doCalcDone() {
        String[][] arrayForCalc = {{"5", "9", "3", "1"},
                {"1", "0", "2", "4"},
                {"2", "9", "1", "7"},
                {"4", "8", "7", "6"}};
        int sum = new ArrayValueCalculator().doCalc(arrayForCalc);
        assertEquals(69, sum);
    }

    @Test
    void doCalcArrayDataException() {
        String[][] arrayForCalc = {{"5", "9", "3", "1"},
                {"1", "0", "2", "4"},
                {"2", "9q", "1", "7"},
                {"4", "8", "7", "6"}};
        var target = new ArrayValueCalculator();
        //ArrayValueCalculator target = new ArrayValueCalculator();
        Exception e = assertThrows(ArrayDataException.class, () -> target.doCalc(arrayForCalc));
        assertEquals("Не вірні дані в комірці: [3][2] = 9q",e.getMessage());
    }

    @Test
    void doCalcArraySizeExceptionMoreRows() {
        String[][] arrayForCalc = {{"5", "9", "3", "1"},
                {"1", "0", "2", "4"},
                {"2", "9", "1", "7"},
                {"4", "8", "7", "6"},
                {"4", "8", "7", "6"}};
        ArrayValueCalculator target = new ArrayValueCalculator();
        Exception exception = assertThrows(ArraySizeException.class, () -> target.doCalc(arrayForCalc));
        assertEquals(exception.getMessage(), "Масив не вірного розміру! Повинен бути 4х4!");
    }
    @Test
    void doCalcArraySizeExceptionMoreColumns() {
        String[][] arrayForCalc = {{"5", "9", "3", "1"},
                {"1", "0", "2", "4","5"},
                {"2", "9", "1", "7"},
                {"4", "8", "7", "6"}};
        ArrayValueCalculator target = new ArrayValueCalculator();
        Exception exception = assertThrows(ArraySizeException.class, () -> target.doCalc(arrayForCalc));
        assertEquals(exception.getMessage(), "Масив не вірного розміру! Срока 2 має містит 4, а не 5");
    }

}