package offer;

public class UglyNumber_49 {

    public int nthUglyNumber(int n) {
        int a=0,b=0,c=0;
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int num_a = dp[a]*2;
            int num_b = dp[b]*3;
            int num_c = dp[c]*5;
            dp[i]= Math.min(num_a,Math.min(num_b,num_c));
            if (dp[i] == num_a)a++;
            if (dp[i] == num_b)b++;
            if (dp[i] == num_c)c++;

        }
        return dp[n-1];
    }
}
