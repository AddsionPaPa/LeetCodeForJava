package testbank;

public class MaximumProductSubarray_152 {
    public int maxProduct(int[] nums) {
        /**
         * dp[i][0] 表示以i结尾的子数组最大值
         * dp[i][1] 表示以i结尾的子数组最小值
         */
        int length = nums.length;
        int[][] dp = new int[length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]),nums[i]);
            dp[i][1] = Math.min(Math.min(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]),nums[i]);
        }
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            temp = Math.max(temp,dp[i][0]);
        }

        return temp;
    }
}
