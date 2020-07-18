package testbank;

public class FindPeakElement_162 {
    public int pos=-1;
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        if (length == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[length-1] > nums[length-2]) {
            return length-1;
        }
        binarySearch(nums,0,length-1);
        return pos;
    }

    public void binarySearch(int[] nums, int left, int right) {
        if (left + 1 < right) {
            int mid = (left+right)/2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                pos = mid;
                return;
            } else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                binarySearch(nums,left,mid);
                binarySearch(nums,mid,right);
            }
            else if(nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]){
                binarySearch(nums,left,mid);
                binarySearch(nums,mid+1,right);
            }
            else {
                binarySearch(nums,left,mid-1);
                binarySearch(nums,mid,right);
            }
        }
    }
}
