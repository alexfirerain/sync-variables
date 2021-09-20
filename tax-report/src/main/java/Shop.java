import java.util.Arrays;
import java.util.Random;

public class Shop {
    private static final int maxRevenuesNumber = 201;          // максимальное количество приходов за день
    private static final int maxSingleRevenue = 18_000_01;     // максимальный приход в копейках

    private final int[] revenues;

    public int[] getRevenues() {
        return revenues;
    }

    public Shop() {
        revenues = new int[new Random().nextInt(maxRevenuesNumber)];
        for (int i = 0; i < revenues.length; i++)
            revenues[i] = new Random().nextInt(maxSingleRevenue);
    }

    @Override
    public String toString() {
        return super.toString() + " " + Arrays.toString(revenues);
    }
}
