package dp;

import java.util.Comparator;
import java.util.stream.IntStream;

class Solution1402 {

    public static int maxSatisfaction(int[] satisfaction) {
        int[] array = IntStream.of(satisfaction).boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int s = 0;
        int f = 0;
        for (int i = 0; i < array.length; i++) {
            s += array[i];
            if (s <= 0) {
                break;
            }
            f += s;
        }
        return f;
    }
}