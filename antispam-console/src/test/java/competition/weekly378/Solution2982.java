package competition.weekly378;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2982. 找出出现至少三次的最长特殊子字符串 II
 * https://leetcode.cn/problems/find-longest-special-substring-that-occurs-thrice-ii/description/
 * 分类讨论
 */
class Solution2982 {
    public static int maximumLength(String s) {
        List<Integer>[] groups= new ArrayList[26];
        Arrays.setAll(groups, x -> new ArrayList<Integer>());
        char[] chars = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < chars.length; i++) {
            cnt++;
            if (i == chars.length - 1 || chars[i] != chars[i + 1]){
                groups[chars[i] - 'a'].add(cnt);
                cnt = 0;
            }
        }
        int ans = 0;
        for (List<Integer> group : groups) {
            if (group.isEmpty()){
                continue;
            }
            group.sort((a, b) -> b - a);
            group.add(0);
            group.add(0);
            int res1 = group.get(0) - 2;
            int res2 = 0;
            if (group.get(0) > group.get(1)){
                res2 = group.get(1);
            }else{
                res2 = group.get(1) - 1;
            }
            int res3 = group.get(2);

            ans = Math.max(ans, Math.max(res1 , Math.max(res2, res3)));
        }
        return ans == 0 ? -1 : ans;
    }

    public static void main(String[] args) {
        maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde");
    }
}