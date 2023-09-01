package threads;

public class ArrayInitializer {
    private static double[] arr;
    private static double[] array1;
    private static double[] array2;

    public static double[] getArr() {
        return arr;
    }

    public static void init(double[] array) throws InterruptedException {
        if (array.length % 2 != 0)
            return;
        arr = new double[array.length];
        initHelperArray(array);

        Thread firstArrayThread = new Thread(() -> {
            System.out.println("Start firstArrayThread");
            mathArray(array1);
            System.out.println("End firstArrayThread");
        });

        Thread secondArrayThread = new Thread(() -> {
            System.out.println("Start secondArrayThread");
            mathArray(array2);
            System.out.println("End secondArrayThread");
        });

        firstArrayThread.start();;
        secondArrayThread.start();

        firstArrayThread.join();
        secondArrayThread.join();

        mergeArray();
    }

    private static void initHelperArray(double[] array) {
        int length = array.length;
        array1 = new double[(length) / 2];
        array2 = new double[length - array1.length];
        for (int i = 0; i < length; i++)
            if (i < array1.length)
                array1[i] = array[i];
            else
                array2[i - array1.length] = array[i];
    }

    private static void mathArray(double[] array) {
        for (var i = 0; i < array.length; i++)
            array[i] = (array[i] * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0));
    }

    private static void mergeArray() {
        for (var i = 0; i < array1.length; i++)
            arr[i] = array1[i];
        for (var i = 0; i < array2.length; i++)
            arr[array1.length + i] = array2[i];
    }
}
