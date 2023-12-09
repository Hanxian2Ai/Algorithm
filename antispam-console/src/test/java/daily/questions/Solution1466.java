package daily.questions;

import com.hanxian.antispam.console.AntispamConsoleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = AntispamConsoleApplication.class)
class Solution1466 {

    public int minReorder(int n, int[][] connections) {
        List<int[]>[] e = new List[n];
        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList<>();
        }
        for (int[] edge : connections) {
            int x = edge[0];
            int y = edge[1];
            e[x].add(new int[]{y, 1});
            e[y].add(new int[]{x, 0});
        }
        return dfs(0, -1, e);
    }

    public int dfs(int x, int parent, List<int[]>[] e) {
        int res = 0;
        for (int[] edge : e[x]) {
            if (edge[0] == parent) {
                continue;
            }
            res += edge[1] + dfs(edge[0], x, e);
        }
        return res;
    }
    @Test
    public void test(){
        int[][] c = {{1,0},{1,2},{3,2},{3,4}};
        minReorder(5, c);
    }
}