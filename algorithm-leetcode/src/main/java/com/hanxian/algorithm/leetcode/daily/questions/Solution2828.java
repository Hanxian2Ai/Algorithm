package com.hanxian.algorithm.leetcode.daily.questions;

import java.util.List;

class Solution2828 {
    public boolean isAcronym(List<String> words, String s) {
        if(words.size() != s.length()){
            return false;
        }
        for(int i = 0; i < words.size();i++){
            if(words.get(i).charAt(0) != s.charAt(i)){
                return false;
            }
        }
        return true;
    }
}