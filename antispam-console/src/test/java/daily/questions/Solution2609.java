package daily.questions;

class Solution2609 {
    public int findTheLongestBalancedSubstring(String s) {
        int res = 0;
        int mark = 0;
        int countZero = 0;
        int idx = 0;
        while (idx < s.length()) {
            int a = 0;
            int b = 0;
            while(idx < s.length() && s.charAt(idx) == '0'){
                a++;
                idx++;
            }
            while(idx < s.length() && s.charAt(idx) == '1'){
                b++;
                idx++;
            }
            res = Math.max(Math.min(a,b) * 2,res);
        }
        return res;
    }
}