package competition.weekly378;

public class LongestSpecialSubstring {
    public static int longestSpecialSubstring(String s) {
        int n = s.length();
        int maxLength = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                String substring = s.substring(i, j + 1);
                if (isSpecial(substring) && substring.length() > maxLength) {
                    maxLength = substring.length();
                }
            }
        }

        return maxLength;
    }

    private static boolean isSpecial(String s) {
        char firstChar = s.charAt(0);
        for (char c : s.toCharArray()) {
            if (c != firstChar) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcaba";
        int result = longestSpecialSubstring(s);
        System.out.println("最长特殊子字符串的长度为: " + result);
    }
}
