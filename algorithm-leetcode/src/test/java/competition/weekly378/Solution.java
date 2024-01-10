package competition.weekly378;

public class Solution {
    public static String longestConsecutiveSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return ""; // 空字符串或null则返回空字符串
        }

        int start = 0; // 当前连续相同子串的起始位置
        int currentLength = 1; // 当前连续相同子串的长度
        int maxLength = 1; // 最长连续相同子串的长度
        int maxStart = 0; // 最长连续相同子串的起始位置

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                // 当前字符与前一个字符相同，更新当前连续相同子串的长度
                currentLength++;
            } else {
                // 当前字符与前一个字符不同，重置当前连续相同子串的起始位置和长度
                start = i;
                currentLength = 1;
            }

            // 更新最长连续相同子串的信息
            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxStart = start;
            }
        }

        // 截取最长连续相同子串并返回
        return s.substring(maxStart, maxStart + maxLength);
    }

    public static void main(String[] args) {
        String s = "aabbbbbccccdd";
        String result = longestConsecutiveSubstring(s);
        System.out.println("最长连续相同子串为: " + result);
    }
}
