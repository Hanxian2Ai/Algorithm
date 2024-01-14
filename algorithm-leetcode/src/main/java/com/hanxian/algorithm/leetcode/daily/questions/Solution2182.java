package com.hanxian.algorithm.leetcode.daily.questions;

/**
 * 2182. 构造限制重复的字符串
 * https://leetcode.cn/problems/construct-string-with-repeat-limit/description/
 * 贪心模拟
 */
class Solution2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int repeatNum = 0;
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 25, j = 24; i >= 0 && j >= 0;){
            if(count[i] == 0){
                repeatNum = 0;
                i--;
            }else if(repeatNum < repeatLimit){
                count[i]--;
                strBuilder.append((char)('a' + i));
                repeatNum++;
            }else if(j >= i || count[j] == 0){
                j--;
            }else {
                count[j]--;
                strBuilder.append((char)('a' + j));
                repeatNum = 0;
            }
        }

        return strBuilder.toString();
    }
}