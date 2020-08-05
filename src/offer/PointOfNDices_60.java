package offer;

import java.util.Arrays;

public class PointOfNDices_60 {
    public double[] twoSum(int n) {
        int[][] dp = new int[12][77];
        for (int i = 0; i <12 ; i++) {
            Arrays.fill(dp[i],0);
        }
        for (int i = 1; i <=6 ; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k < 1) {
                        break;
                    }
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        double[] res= new double[6*n-n+1];
        int sum=0;
        for (int i = n; i <6*n+1 ; i++) {
            sum+=dp[n][i];
        }
        for (int i = 0; i <6*n-n+1 ; i++) {
            res[i] = dp[n][i+n]*1.0/sum;
        }
        return res;
    }
}
