package daily.questions;

import java.util.HashMap;
import java.util.Map;

class Solution2048 {
    public int nextBeautifulNumber(int n) {
        for(n++; n <=1_224_444; n++){
            if (isBalance(n)){
                return n;
            }
        }
        return -1;
    }

    private boolean isBalance(int n){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while(n > 0){
            int bit = n % 10;
            n /= 10;
            hashMap.put(bit, hashMap.getOrDefault(bit, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() != entry.getKey()){
                return false;
            }
        }
        return true;
    }
}