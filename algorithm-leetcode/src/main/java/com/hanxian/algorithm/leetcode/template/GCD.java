package com.hanxian.algorithm.leetcode.template;

/**
 * 欧几里得算法,辗转相除法
 * 最大公约数
 */
public class GCD {
    public int gcd(int a, int b){
        if (b == 0){
            return a;
        }
        int c = a % b;
        return gcd(b , c);
    }
}
