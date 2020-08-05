package testbank;

public class HouseRobber_198 {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return  0;
        }
        // dp[i][0] 表示以i结尾的数组最大获益值
        // dp[i][1] 表示i元素是否被标记使用
        int[][] dp = new int[length+1][2];
        dp[0][0] = 0;
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        dp[1][1] = 1;
        for (int i = 2; i < length+1; i++) {
            if (dp[i - 1][1] == 0) {
                dp[i][0] = dp[i - 1][0] + nums[i - 1];
                dp[i][1] = 1;
            } else {
                if (nums[i - 1] + dp[i - 2][0] > dp[i - 1][0] && dp[i-1][1]==1) {
                    dp[i][0] = nums[i - 1] + dp[i - 2][0];
                    dp[i][1] = 1;
                }
                else {
                    dp[i][0] = dp[i-1][0];
                    dp[i][1] = 0;
                }
            }
        }
        return dp[length][0];
    }
}
