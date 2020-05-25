public class MergeTwoSortedArrays_088 {
    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int nums1_pos=m-1,nums2_pos=n-1;
        int i=m+n-1;
        while (nums1_pos >= 0 && nums2_pos >= 0 && i>=0) {
            if (nums1[nums1_pos] > nums2[nums2_pos]) {
                    nums1[i] = nums1[nums1_pos];
                    nums1_pos--;
            }
            else {
                    nums1[i] = nums2[nums2_pos];
                    nums2_pos--;
            }
            i--;
        }
       if (i==-1){
           return;
       }
       else if (nums1_pos<0 && nums2_pos>=0){
           while (i>=0){
               nums1[i--]=nums2[nums2_pos--];
           }
       }
       else {
           return;
       }
    }
}
