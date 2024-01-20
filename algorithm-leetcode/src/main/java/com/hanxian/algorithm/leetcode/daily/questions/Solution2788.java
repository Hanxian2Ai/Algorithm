package com.hanxian.algorithm.leetcode.daily.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * 2788. 按分隔符拆分字符串
 * https://leetcode.cn/problems/split-strings-by-separator/description/
 * 注意 split 里面是正则表达式 .有特殊含义 要加转义字符\\
 */
class Solution2788 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        ArrayList<String> res = new ArrayList<>();
        for (String word : words) {
            int index = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == separator) {
                    String substring = word.substring(index, i);
                    index = i + 1;
                    if (!"".equals(substring)){
                        res.add(substring);
                    }
                }
                if (i == word.length() - 1 && index <  word.length() - 1){
                    String substring = word.substring(index, i + 1);
                    res.add(substring);
                }
            }
        }
        return res;
    }
}