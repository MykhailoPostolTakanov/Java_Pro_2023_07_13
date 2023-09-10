package threadsadvanced;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ArrayInitializerAdvanced extends RecursiveTask<double[]> {
    private final double[] array;

    public ArrayInitializerAdvanced(double[] array) {
        this.array = array;
    }

    private void mathArray(boolean isFirstPart) {
        int indexForParts = 0;
        if (!isFirstPart)
            indexForParts = array.length / 2;
        for (var i = 0; i < array.length / 2; i++)
            array[i + indexForParts] = (array[i + indexForParts] * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0));
    }

    @Override
    protected double[] compute() {
        if (array.length < 100) {
            mathArray(true);
            mathArray(false);
            return array;
        }
        ArrayInitializerAdvanced firstHalfArray = new ArrayInitializerAdvanced(Arrays.copyOfRange(array, 0, array.length / 2));
        ArrayInitializerAdvanced secondHalfArray = new ArrayInitializerAdvanced(Arrays.copyOfRange(array, array.length / 2, array.length));
        firstHalfArray.fork();
        secondHalfArray.fork();
        return concatWithArrayCopy(firstHalfArray.join(), secondHalfArray.join());
    }

    static double[] concatWithArrayCopy(double[] array1, double[] array2) {
        double[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }
}
