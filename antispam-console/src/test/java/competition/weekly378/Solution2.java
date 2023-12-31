package competition.weekly378;

import java.util.HashMap;

class Solution2 {
    public static int maximumLength(String s) {
        int count = -1;
        String repeat = longestConsecutiveSubstring(s);
        if (repeat.length() >= 3){
            if (find(repeat.length(), s, repeat)){
                return repeat.length();
            }else if(find(repeat.length() - 1, s, repeat)){
                return repeat.length() - 1;
            }else{
                return repeat.length() - 2;
            }
        }else if (repeat.length() == 2){
            if (find(2, s, repeat)){
                return 2;
            }else if(find(1, s, repeat)){
                return 1;
            }else{
                return -1;
            }
        }else if (repeat.length() == 1){
            if(find(1, s, repeat)){
                return 1;
            }else{
                return -1;
            }
        }
        for (int i = 1; i <= s.length() - 2; i++) {
            if (find(i, s, repeat)){
                count = i;
            }
        }
        return count;
    }

    private static boolean find(int size, String s, String repeat){
        String substring1 = repeat.substring(0, size);
        HashMap<String, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i <= chars.length - size; i++) {
            String substring = s.substring(i, i + size);
            if (size >= 3 && substring.equals(substring1)){
                map.put(substring, map.getOrDefault(substring, 0) + 1);
                if (map.get(substring) >= 3){
                    return true;
                }
            }else if (special(substring)){
                map.put(substring, map.getOrDefault(substring, 0) + 1);
                if (map.get(substring) >= 3){
                    return true;
                }
            }


        }
        return false;
    }

    private static boolean special(String s){
        char c = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != c){
                return false;
            }
        }
        return true;
    }

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
                currentLength++;
            } else {
                start = i;
                currentLength = 1;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxStart = start;
            }
        }

        return s.substring(maxStart, maxStart + maxLength);
    }

    public static void main(String[] args) {
        maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde");
    }
}