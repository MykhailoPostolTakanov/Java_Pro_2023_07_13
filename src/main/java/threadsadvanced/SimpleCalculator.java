package threadsadvanced;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SimpleCalculator {
    public static int squareSum(int first, int second) throws ExecutionException, InterruptedException {
        Future<Integer> completableFutureFirst =
                CompletableFuture.completedFuture(square(first));
        Future<Integer> completableFutureSecond =
                CompletableFuture.completedFuture(square(second));
        return completableFutureFirst.get() + completableFutureSecond.get();
    }

    private static int square(int number) {
        return number * number;
    }
}
