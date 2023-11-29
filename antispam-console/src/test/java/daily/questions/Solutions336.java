package daily.questions;

import java.util.PriorityQueue;
import java.util.TreeSet;

class Solutions2336 {

    private int mark;
    private final TreeSet<Integer> set;

    public Solutions2336() {
        mark = 1;
        set = new TreeSet<>();
    }

    public int popSmallest() {
        if (set.isEmpty()) {
            int ans = mark;
            mark++;
            return ans;
        }
        int ans = set.pollFirst();
        return ans;
    }

    public void addBack(int num) {
        if (num < mark) {
            set.add(num);
        }
    }
//    优先队列的做法
//    class SmallestInfiniteSet {
//        private static int mark;
//        private final PriorityQueue<Integer> queue;
//
//        public SmallestInfiniteSet() {
//            mark = 1;
//            queue = new PriorityQueue<Integer>();
//        }
//
//        public int popSmallest() {
//            if (queue.isEmpty()) {
//                int ans = mark;
//                mark++;
//                return ans;
//            }
//            int ans = queue.poll();
//            return ans;
//        }
//
//        public void addBack(int num) {
//            if (!queue.contains(num) && num < mark) {
//                queue.offer(num);
//            }
//        }
//    }

}
