package daily.questions;

import java.util.Arrays;

class Solution1657 {
    private static final int SIZE = 26;

    public boolean closeStrings(String word1, String word2) {
        int w1Size = word1.length();
        int w2Size = word2.length();
        if (w1Size != w2Size){
            return false;
        }
        int[] w1 = new int[SIZE];
        int[] w2 = new int[SIZE];

        for (int i = 0; i < w1Size; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            w1[c1-'a']++;
            w2[c2-'a']++;
        }

        for (int i = 0; i < SIZE; i++) {
            if((w1[i] == 0 && w2[i] != 0) || (w2[i] == 0 && w1[i] != 0)){
                return false;
            }
        }
        Arrays.sort(w1);
        Arrays.sort(w2);
        for (int i = 0; i < SIZE; i++) {
            if(w1[i] != w2[i]){
                return false;
            }
        }
        return Arrays.equals(w1,w2);
    }
}