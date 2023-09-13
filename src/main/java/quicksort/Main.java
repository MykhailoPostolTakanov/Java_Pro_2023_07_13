package quicksort;

import java.time.LocalDateTime;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int[] array = random.ints(500_000, 10, 100).toArray();
        System.out.println("Time Start First: " + LocalDateTime.now());
        QuikSort.quikSort(array, 0, array.length);
        System.out.println("Time End First: " + LocalDateTime.now());

        int[] array2 = random.ints(1_000_000, 10, 100).toArray();
        System.out.println("Time Start Second: " + LocalDateTime.now());
        QuikSort.quikSort(array2, 0, array2.length);
        System.out.println("Time End Second: " + LocalDateTime.now());
    }
}
