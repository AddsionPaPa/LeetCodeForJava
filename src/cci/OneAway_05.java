package cci;

public class OneAway_05 {
    public boolean oneEditAway(String first, String second) {
        int[][] dp = new int[first.length()+1][second.length()+1];
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        dp[0][0]=0;
        for (int i = 0; i < second.length() + 1; i++) {
                dp[0][i] = i;
        }
        for (int i = 0; i < first.length() + 1; i++) {
                dp[i][0] = i;
        }
        for (int i = 1; i < first.length() + 1; i++) {
            for (int j = 1; j < second.length() + 1; j++) {
                if (first.charAt(i-1) == second.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]) )+1;
                }
            }
        }
        if (dp[first.length()][second.length()] <2){
            return true;
        }
        return false;
    }
}
