package offer;

import java.util.HashMap;
import java.util.Map;

public class TranslateIntegerToString_46 {

    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length()+1];

        // dp[i]表示以i结尾的数字所表示的翻译个数
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < str.length()+1; i++) {
            char c = str.charAt(i);
            if (str.charAt(i - 2) > '2' || str.charAt(i-2) == '0') {
                dp[i] = dp[i-1];
            } else if (str.charAt(i - 2) == '1') {
                dp[i] = dp[i-1] +dp[i-2];
            }
            else {
                if (c>'5'){
                    dp[i] =dp[i-1];
                }
                else {
                    dp[i]= dp[i-1]+dp[i-2];
                }
            }
        }
        return dp[str.length()];
    }
}
