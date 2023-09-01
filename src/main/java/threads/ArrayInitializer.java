package threads;

public class ArrayInitializer {
    private static double[] arr;

    public static double[] getArr() {
        return arr;
    }

    public static void init(double[] array) {
        try {
            if (array.length % 2 != 0)
                return;
            arr = new double[array.length];

            Thread firstArrayThread = new Thread(() -> {
                System.out.println("Start firstArrayThread");
                mathArray(array, true);
                System.out.println("End firstArrayThread");
            });

            Thread secondArrayThread = new Thread(() -> {
                System.out.println("Start secondArrayThread");
                mathArray(array, false);
                System.out.println("End secondArrayThread");
            });

            firstArrayThread.start();
            secondArrayThread.start();

            firstArrayThread.join();
            secondArrayThread.join();

            mergeArray(array);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    private static void mathArray(double[] array, boolean isFirstPart) {
        int indexForParts = 0;
        if (!isFirstPart)
            indexForParts = array.length / 2;
        for (var i = 0; i < array.length / 2; i++)
            array[i + indexForParts] = (array[i + indexForParts] * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0));
    }

    private static void mergeArray(double[] array) {
        System.arraycopy(array, 0, arr, 0, array.length);
    }
}
