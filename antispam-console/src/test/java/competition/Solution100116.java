package competition;

import java.util.HashSet;

class Solution100116 {
    public int findChampion(int n, int[][] edges) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            set.add(edges[i][1]);
        }
        if (n - set.size() >=2){
            return -1;
        }
        for (int i = 0; i < n; i++) {
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
}