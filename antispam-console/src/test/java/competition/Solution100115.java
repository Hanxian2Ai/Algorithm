package competition;

import java.util.HashSet;

class Solution100115 {
    public int findChampion(int[][] grid) {
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1){
                    map.add(j);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            if (!map.contains(i)){
                return  i;
            }
        }
        return -1;
    }
}