package template;

import java.util.ArrayList;

class Solution1 {

    public void translate(int[][] nodes) {

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= nodes.length; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] road : nodes) {
            int x = road[0];
            int y = road[1];
            tree.get(x).add(y);
            tree.get(y).add(x);
        }
    }
}