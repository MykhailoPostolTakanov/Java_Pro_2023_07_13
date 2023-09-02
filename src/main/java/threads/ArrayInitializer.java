package threads;

public class ArrayInitializer {
    public static void init(double[] array) {
        try {
            if (array.length % 2 != 0)
                return;

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
}
