package testbank;

public class FindMinimumInRotatedSortedArrayII_154 {
    public int res;
    public boolean flag = false;
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 1) {
            return nums[0];
        }
        Integer.parseInt("da");
        binarySearch(nums,left,right);
        if (flag){
            return res;
        }
        return nums[0];
    }

    public void binarySearch(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid + 1]) {
             res = nums[mid+1];
             flag = true;
             return;
        }

        if (nums[left] == nums[right] && left!=right-1) {
                binarySearch(nums,left,mid);
                binarySearch(nums,mid,right);
        }
        else {
            if (nums[left] > nums[mid]) {
                binarySearch(nums,left,mid);
            }
            if (nums[right] < nums[mid]) {
                binarySearch(nums,mid,right);
            }
        }

    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArrayII_154 test=new FindMinimumInRotatedSortedArrayII_154();
        test.findMin(new int[]{1,1});
    }
}
