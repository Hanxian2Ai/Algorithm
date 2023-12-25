package daily.questions;

import com.hanxian.antispam.console.AntispamConsoleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

// todo
@SpringBootTest(classes = AntispamConsoleApplication.class)
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }

        for (int i = 1; i < s.length(); i++) {
            char front = s.charAt(i - 1);
//            if (s.charAt(i -1) != '0'){
//                dp[i] += dp[i - 1];
//            }
//            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
//                dp[i] += dp[i - 2];
//            }

        }
        return dp[s.length() -1];
    }


    @Test
    public void test() {
        numDecodings("10");
    }
}