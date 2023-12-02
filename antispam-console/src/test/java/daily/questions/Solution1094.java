package daily.questions;

import java.util.TreeMap;

class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> d = new TreeMap<>();
        for (int[] t : trips) {
            int num = t[0], from = t[1], to = t[2];
            d.merge(from, num, Integer::sum);
            d.merge(to, -num, Integer::sum);
        }
        int s = 0;
        for (int v : d.values()) {
            s += v;
            if (s > capacity) {
                return false;
            }
        }
        return true;
    }
}
