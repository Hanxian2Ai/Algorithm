package backtracking;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution77 {

    static LinkedList<Integer> path = new LinkedList<>();

    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        path.add(1);
        res.add(path);
        System.out.println(res);
    }
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return res;
    }

    public void backTracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(path);
            return;
        }
        for (int i = startIndex; i < n; i++) {
            path.add(startIndex);
            backTracking(n, k, i + 1);
            path.removeLast();
        }
    }
}