package testbank;

import org.junit.Test;

public class RobHousesII_213 {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int max1 = nums[0];
        int max2 = nums[1];
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length-1 ; i++) {
            if (i == 1 ) {
                if (nums[i]>nums[i-1]){
                    dp[i] = nums[i];
                }
                else {
                    dp[i] = dp[i-1];
                }
            }
            else {
                if (dp[i - 2]+ nums[i] > dp[i - 1]) {
                    dp[i]= dp[i - 2] + nums[i];
                }
                else{
                    dp[i] = dp[i-1];
                }
            }
            max1 = Math.max(dp[i],max1);
        }
        dp[1] = nums[1];
        for (int i = 2; i < length; i++) {
            if (i==2){
                if (nums[i]>nums[i-1]){
                    dp[i] = nums[i];
                }
                else {
                    dp[i] = dp[i-1];
                }
            }
            else {
                if (dp[i - 2]+ nums[i] > dp[i - 1]) {
                    dp[i]= dp[i - 2] + nums[i];
                }
                else{
                    dp[i] = dp[i-1];
                }
            }
            max2=Math.max(dp[i],max2);
        }

        return Math.max(max1,max2);
    }

    @Test
    public void fun() {
        System.out.println(rob(new int[]{2,3,2}));

    }
}
