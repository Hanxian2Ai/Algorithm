package com.hanxian.algorithm.leetcode.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * 2696. 删除子串后的字符串最小长度
 * https://leetcode.cn/problems/minimum-string-length-after-removing-substrings/description/
 * ArrayList模拟栈操作
 */
class Solution2696 {
    public static int minLength(String s) {
        boolean needDelete = true;
        String afterDelete = s;
        while(needDelete){
            needDelete = false;
            StringBuilder stringBuilder = new StringBuilder(afterDelete);
            for (int i = 0; i < afterDelete.length() - 1; i++) {
                String substring = afterDelete.substring(i, i + 2);
                if ("AB".equals(substring) || "CD".equals(substring)){
                    stringBuilder.delete(i, i + 2);
                    needDelete = true;
                    i++;
                }
                afterDelete = stringBuilder.toString();
            }
        }
       return afterDelete.length();

    }

    public int minLength2(String s) {
        List<Character> stack = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.add(c);
            int m = stack.size();
            if (m >= 2 &&
                    (stack.get(m - 2) == 'A' && stack.get(m - 1) == 'B' ||
                            stack.get(m - 2) == 'C' && stack.get(m - 1) == 'D')) {
                stack.remove(m - 1);
                stack.remove(m - 2);
            }
        }
        return stack.size();
    }
}