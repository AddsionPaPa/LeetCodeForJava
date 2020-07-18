package offer;

public class CutInteger_14 {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int temp = 0;
            for (int j = 1; j < i; j++) {

                temp = Math.max(dp[j]*(i-j),j*(i-j));
                dp[i] = Math.max(dp[i],temp);
            }
        }
        return dp[n];
    }
}
