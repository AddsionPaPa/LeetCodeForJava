import java.util.Arrays;

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int[] pre = new int[nums.length];
        int maxlength = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                pre[i] = 1;
            } else {
                if (nums[i] - 1 == nums[i - 1]) {
                    pre[i] = pre[i - 1] + 1;
                } else if (nums[i] == nums[i - 1]) {
                    pre[i] = pre[i - 1];
                } else {
                    pre[i] = 1;
                }
            }
            maxlength=Math.max(maxlength,pre[i]);
        }
        return maxlength;
    }
}
