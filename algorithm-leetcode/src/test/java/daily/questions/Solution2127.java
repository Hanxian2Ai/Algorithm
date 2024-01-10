package daily.questions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution2127 {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indeg = new int[n];
        for (int i = 0; i < n; ++i) {
            ++indeg[favorite[i]];
        }
        boolean[] used = new boolean[n];
        int[] f = new int[n];
        Arrays.fill(f, 1);
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            used[u] = true;
            int v = favorite[u];
            // 状态转移
            f[v] = Math.max(f[v], f[u] + 1);
            --indeg[v];
            if (indeg[v] == 0) {
                queue.offer(v);
            }
        }

        int ring = 0, total = 0;
        for (int i = 0; i < n; ++i) {
            if (!used[i]) {
                int j = favorite[i];
                if (favorite[j] == i) {
                    total += f[i] + f[j];
                    used[i] = used[j] = true;
                } else {
                    int u = i, cnt = 0;
                    while (true) {
                        ++cnt;
                        u = favorite[u];
                        used[u] = true;
                        if (u == i) {
                            break;
                        }
                    }
                    ring = Math.max(ring, cnt);
                }
            }
        }
        return Math.max(ring, total);
    }
}
