package offer;

import org.junit.Test;

public class FindLostNumber_53 {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right  = nums.length;

        while (left < right) {
            int mid = (right-left)/2+left;
            if (nums[mid] == mid) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        if (left >= nums.length || nums[left] == left) {
            return -1;
        }
        return left;
    }
    @Test
    public void fun() {
        missingNumber(new int[]{0});
    }
}
