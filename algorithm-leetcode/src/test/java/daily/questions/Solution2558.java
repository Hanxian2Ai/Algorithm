package daily.questions;

import java.util.PriorityQueue;

class Solution2558 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        long res = 0;
        for (int gift : gifts) {
            queue.offer(gift);
            res += gift;
        }
        for (int i = 0; i < k; i++) {
            int poll = queue.poll();
            int sqrtNum = (int) Math.sqrt(poll);
            queue.offer(sqrtNum);
            res = res - poll + sqrtNum;
        }
        return res;
    }
}