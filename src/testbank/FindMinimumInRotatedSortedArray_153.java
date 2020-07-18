package testbank;

import com.sun.org.apache.xerces.internal.impl.xs.util.XIntPool;

public class FindMinimumInRotatedSortedArray_153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        if (nums.length == 1) {
            return nums[0];
        }
        return binarySearch(nums,left,right);
    }

    public int binarySearch(int[] nums, int left, int right) {
        int mid = (left+right)/2;
        if (nums[mid] > nums[mid + 1]) {
            return nums[mid+1];
        }
        else {
            if (nums[left]>nums[mid]){
                return binarySearch(nums,left,mid);
            }
            else if (nums[right] < nums[mid]) {
                return binarySearch(nums,mid,right);
            }
            else {
                return nums[0];
            }
        }
    }
}
