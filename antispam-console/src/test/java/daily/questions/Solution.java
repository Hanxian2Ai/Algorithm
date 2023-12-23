package daily.questions;

import com.hanxian.antispam.console.AntispamConsoleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.PriorityQueue;

/**
 * 1962. 移除石子使总数最小
 * 优先队列 堆 原地堆化
 */
@SpringBootTest(classes = AntispamConsoleApplication.class)
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int pile : piles) {
            queue.offer(pile);
            sum += pile;
        }

        int cut = 0;
        for (int i = 0; i < k; i++) {
            int poll = queue.poll();
            int cutItem = poll >> 1;
            cut += cutItem;
            queue.add(poll - cutItem);
        }
        return sum - cut;
    }

    @Test
    public void test(){
        minStoneSum(new int[]{4,3,6,7}, 3);

    }
}
