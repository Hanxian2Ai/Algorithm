package daily.questions;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution1670 {

    private final Deque<Integer> left = new ArrayDeque<>();

    private final Deque<Integer> right = new ArrayDeque<>();

    private int size = 0;

    public Solution1670() {

    }

    private void balance() {
        if (left.size() > right.size()) {
            right.addFirst(left.pollLast());
        } else if (right.size() > left.size() + 1) {
            left.addLast(right.pollFirst());
        }
    }

    public void pushFront(int val) {
        left.addFirst(val);
        balance();
        size++;
    }

    public void pushMiddle(int val) {
        left.addLast(val);
        balance();
        size++;
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
        size++;
    }

    public int popFront() {
        if (size == 0) {
            return -1;
        }
        int val = left.isEmpty() ? right.pollFirst() : left.pollFirst();
        balance();
        size--;
        return val;
    }

    public int popMiddle() {
        int val = -1;
        if (size == 0) {
            return val;
        }
        if (left.size() < right.size()) {
            val = right.pollFirst();
        } else {
            val = left.pollLast();
        }
        size--;
        return val;

    }

    public int popBack() {
        if (size == 0) {
            return -1;
        }
        int val = right.pollLast();
        balance();
        size--;
        return val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */