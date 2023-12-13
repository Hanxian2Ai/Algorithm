package daily.questions;

class Solution2697 {
    public String makeSmallestPalindrome(String s) {
        int size = s.length();
        int right = size - 1;
        char[] ans = s.toCharArray();
        for(int left = 0; left < right; left++,right--){
            char r = ans[right];
            char l = ans[left];
            if (r > l){
                ans[right] = l;
            }else{
                ans[left] = r;
            }
        }
        return new String(ans);
    }
}