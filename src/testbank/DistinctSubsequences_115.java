package testbank;

public class DistinctSubsequences_115 {
    public int numDistinct(String s, String t) {
        int s_len=s.length();
        int t_len=t.length();
        int[][] dp=new int[s_len+2][t_len+2];

        for (int i = 0; i < s_len + 1; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < t_len + 1; i++) {
            dp[i][0]=0;
        }

        for (int i = 1; i < t_len + 1; i++) {
            for (int j = 1; j < s_len + 1; j++) {
                if (t.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
                }
                else {
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[t_len][s_len];
    }
}
