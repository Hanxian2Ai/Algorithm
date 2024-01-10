package com.hanxian.algorithm.leetcode.backtracking;

class Solution2698 {

    public static void main(String[] args) {
        int i = punishmentNumber(10);
        System.out.println(i);
    }
    public static int punishmentNumber(int n) {
        int res = 0;

        for (int i = 1; i <= n; i++) {
            String s = Integer.toString(i * i);
            if (backStacking(s,i,0, 0)){
                res += Integer.parseInt(s);
            }
        }
        return res;

    }
    public static boolean backStacking(String s, int target, int startIndex, int sum){
        if (startIndex == s.length()){
            return sum == target;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            int valueItem = Integer.parseInt(substring);
            if (backStacking(s, target,i + 1,sum + valueItem)){
                return true;
            }
        }
        return false;
    }
}