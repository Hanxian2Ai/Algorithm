package dp;

public class Solution {
    public static void main(String[] args) {
        isSubsequence("abc","ahbgdc");
    }
    public static boolean isSubsequence(String s, String t) {
        int a = s.length();
        int b = s.length();
        int[][] dp = new int[a][b];
        boolean mark = false;

        for(int i = 0; i < b; i++){
            if(s.charAt(0) == t.charAt(i)){
                dp[0][i] = 1;
                mark = true;
            }
            if(mark == true){
                dp[0][i] = 1;
            }
        }
        
        for(int i = 1; i < a; i++){
            for(int j = 1; j < b; j++){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[a -1][b-1]  == a;


    }
}