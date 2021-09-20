import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final int shopsCount = 3;

    public static void main(String[] args) throws InterruptedException {
        List<Shop> shops = IntStream.range(0, shopsCount)
                .mapToObj(i -> new Shop())
                .collect(Collectors.toList());
        LongAdder total = new LongAdder();

        ExecutorService collector = Executors.newFixedThreadPool(shopsCount);
        for (Shop s : shops)
            collector.submit(
                    () -> Arrays.stream(s.getRevenues())
                            .forEach(total::add));

        collector.awaitTermination(3, TimeUnit.SECONDS);

        Long totalSum = total.sum();
        System.out.printf("Общая выручка за этот день (%d магазина): %d коп. (%.2f₱)",
                shopsCount, totalSum, (double) totalSum / 100);

    }
}
